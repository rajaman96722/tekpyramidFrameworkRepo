package com.crm.tekpyramid.orgtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.Baseclass;

public class CreateOrgTest extends Baseclass{
	
	@Test
	public void createOrgTest() {
		System.out.println("execute createorgtest and verify");
	}
	@Test
	public void createOrgWiithIndustries() {
		System.out.println("execute createOrgWithIndustries and verify");
	

}
}