package com.it.study.domain.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ShiftTimeRequest {
  private Integer shiftId;
  private Integer time;
}
