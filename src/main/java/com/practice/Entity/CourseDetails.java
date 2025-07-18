package com.practice.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="registrations")
public class CourseDetails {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String stuname;
	private String coursename;
	private LocalDate regDate;
	private double feespaid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public double getFeespaid() {
		return feespaid;
	}
	public void setFeespaid(double feespaid) {
		this.feespaid = feespaid;
	}
	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", stuname=" + stuname + ", coursename=" + coursename + ", regDate="
				+ regDate + ", feespaid=" + feespaid + "]";
	}	
}
