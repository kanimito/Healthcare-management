<template>
    <div v-if="visible" class="popup">
        <div class="popup-content">
            <div class="content-style">{{ content }}</div>
            <input v-model="query" placeholder="搜索" />
            <div class="items-container">
                <ul>
                    <li v-for="item in filteredItems" :key="item.drugName">
                        <input
                            type="checkbox"
                            :value="item.drugName"
                            v-model="selectedItems"
                            @change="emitSelectedItems"
                        />
                        {{ item.drugName }}
                    </li>
                </ul>
            </div>
            <button class="close-button" @click="closePopup">确定</button>
        </div>
    </div>
</template>
  
  <script>
import { selectDrugsList } from '@/api/doctor';

export default {
    data() {
        return {
            query: '',
            items: [], // 原药品列表
            selectedItems: [] // 用于保存选中的药品
        };
    },
    computed: {
        filteredItems() {
            const query = this.query.toLowerCase();
            return this.items.filter((item) =>
                item.drugName.toLowerCase().includes(query)
            );
        }
    },
    name: 'Popup',
    props: {
        visible: {
            type: Boolean,
            default: false
        },
        content: {
            type: String,
            default: ''
        }
    },
    methods: {
        closePopup() {
            this.$emit('close');
            this.$emit('update:showTable', true); // 触发事件并传递状态
        },
        emitSelectedItems() {
            this.$emit(
                'update:selectedItems',
                this.items.filter((item) =>
                    this.selectedItems.includes(
                        item.drugName,
                        item.drugUnit,
                        item.drugExitPrice,
                        item.drugsId
                    )
                )
            );
        },
        async fetchItems() {
            try {
                const response = await selectDrugsList();
                this.items = response.data.map((item) => ({
                    drugName: item.drugName,
                    drugUnit: item.drugUnit,
                    drugId: item.drugId,
                    drugExitPrice: item.drugExitPrice,
                    selected: false
                }));
            } catch (error) {
                console.error('Failed to fetch items:', error);
            }
        }
    },
    watch: {
        visible(newVal) {
            if (newVal) {
                this.fetchItems();
            }
        }
    },
    mounted() {
        if (this.visible) {
            this.fetchItems();
        }
    }
};
</script>
  
  <style scoped>
.popup {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}
.popup-content {
    background: #fff;
    padding: 20px;
    border-radius: 5px;
    width: 70%;
    max-width: 800px;
    height: 600px;
    display: flex;
    flex-direction: column;
}
.close-button {
    margin-top: 10px;
}
.items-container {
    flex: 1;
    overflow-y: auto;
    max-height: 500px;
}
.content-style {
    font-size: 30px;
    color: orange;
    margin-bottom: 20px;
}
</style>