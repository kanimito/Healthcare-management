package com.it.study.domain.vo;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: web-servlet @BelongsPackage: entity @Author:
 * kanimito @CreateTime: 2024-07-06 16:04 @Description: TODO @Version: 1.0
 */
public class Page {
  /** 总记录数 */
  private Integer count;

  /** 总页数 */
  private Integer totalPage;

  /** 每页显示的数量 */
  private Integer pageSize;

  /** 当前页 */
  private Integer pageNow;

  /** 给sql查询时用的 */
  private Integer startIndex;

  /** 是否有下一页 */
  private boolean hasNext;

  /** 是否有上一页 */
  private boolean hasPrev;

  private Object data;

  public Page(Integer count, Integer pageNow, Integer pageSize) {
    this.count = count;
    this.pageSize = pageSize;
    this.pageNow = pageNow;
  }

  public Integer getCount() {
    return count;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getTotalPage() {
    if (count % pageSize == 0) {
      this.totalPage = count / pageSize;
      return count / pageSize;
    }
    this.totalPage = count / pageSize + 1;
    return count / pageSize + 1;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNow() {
    return pageNow;
  }

  public void setPageNow(Integer pageNow) {
    this.pageNow = pageNow;
  }

  public Integer getStartIndex() {
    this.startIndex = (pageNow - 1) * pageSize;
    return (pageNow - 1) * pageSize;
  }

  public boolean isHasNext() {
    this.hasNext = getTotalPage() > pageNow;
    return getTotalPage() > pageNow;
  }

  public boolean isHasPrev() {
    this.hasPrev = pageNow > 1;
    return pageNow > 1;
  }

  @Override
  public String toString() {
    return "Page{"
        + "count="
        + count
        + ", totalPage="
        + totalPage
        + ", pageSize="
        + pageSize
        + ", pageNow="
        + pageNow
        + ", startIndex="
        + startIndex
        + ", hasNext="
        + hasNext
        + ", hasPrev="
        + hasPrev
        + '}';
  }
}
