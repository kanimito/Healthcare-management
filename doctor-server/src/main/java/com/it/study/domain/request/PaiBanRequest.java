package com.it.study.domain.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PaiBanRequest {

  private Date date;
  private Integer dcId;
  private Integer dId;
  private Integer dDoctorId;
  private Integer status;
  private Integer shiftId;
  private List<ShiftTimeRequest> shiftTime;
}
