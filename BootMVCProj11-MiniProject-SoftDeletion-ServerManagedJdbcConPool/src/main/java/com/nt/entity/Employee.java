package com.nt.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="emp1")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Data
@SQLDelete(sql = "update  emp1  set status='inactive' where empno=?")
@SQLRestriction(value = " status   <> 'inactive' ")
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_eno_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer  empno;
	//@NonNull
	@Column(length = 30)
	private  String   ename;
	//@NonNull
	@Column(length = 30)
	private  String   job;
	//@NonNull
	private   Double  sal;
	//@NonNull
	private   Integer  deptno=30;
	private   String status="active";

}
