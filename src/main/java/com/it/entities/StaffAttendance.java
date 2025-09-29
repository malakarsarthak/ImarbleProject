package com.it.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StaffAttendance 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer attendenceId;
   
   @ManyToOne()
   @JoinColumn(name = "staffid", nullable = false)
   private Staff staff;
   
   @Column(name = "Date", nullable = false)
   private LocalDate attendanceDate;
   
   @Column(name = "Status", nullable = false)
   private boolean attendenceStatus;
}
