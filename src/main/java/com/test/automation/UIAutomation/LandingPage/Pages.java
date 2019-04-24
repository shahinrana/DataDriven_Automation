package com.test.automation.UIAutomation.LandingPage;

import org.openqa.selenium.support.PageFactory;

import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.Candidates.AssignCandidatePage;
import com.test.automation.UIAutomation.uiActions.Candidates.CandidateListPage;
import com.test.automation.UIAutomation.uiActions.Candidates.NewCandidatePage;
import com.test.automation.UIAutomation.uiActions.Dashboard.AmKpiPage;
import com.test.automation.UIAutomation.uiActions.Dashboard.CallerPanelPage;
import com.test.automation.UIAutomation.uiActions.Dashboard.DashboardMainPage;
import com.test.automation.UIAutomation.uiActions.Dashboard.SubDashboardPage;
import com.test.automation.UIAutomation.uiActions.Requirements.NewRequirement;
import com.test.automation.UIAutomation.uiActions.Requirements.UpdateRegisterationdetailsPage;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.CandidateDetailPage;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Conversation;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Email;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Interview;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.OfferAccepted;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.OfferReceived;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Prospective;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.RequirementDetailsPage;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.RequirmentLifeCycle;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.SMSSendToCandidate;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Shortlisted;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.Submission;
import com.test.automation.UIAutomation.uiActions.RequirementsLifeCycle.SubmissionDetailsPage;;

public class Pages extends TestBase
{
	
	public Pages()
	{
		PageFactory.initElements(driver, this);		
	}
	
	public static HomePage homapage()
	{
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
	public static LoginPage loginpage()
	{
		return PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	public static CandidateListPage candidatelist()
	{
		return PageFactory.initElements(driver, CandidateListPage.class);
	}
	
	public static NewCandidatePage CandidateDetails()
	{
		return PageFactory.initElements(driver, NewCandidatePage.class);
	}
	
	public static RequirementDetailsPage RequirementDetails()
	{
		return PageFactory.initElements(driver,RequirementDetailsPage.class);
	} 

	public static NewRequirement NewRequirement()
	{
		return PageFactory.initElements(driver,NewRequirement.class);
	} 
	public static UpdateRegisterationdetailsPage UpdateRegisterationdetailsPage()
	{
		return PageFactory.initElements(driver,UpdateRegisterationdetailsPage.class);
	} 	
		
	public static AssignCandidatePage AssignCandidatePage()
	{
		return PageFactory.initElements(driver,AssignCandidatePage.class);
	} 	
	
	public static DashboardMainPage DashboardMainPage()
	{
		return PageFactory.initElements(driver,DashboardMainPage.class);
		
	}
	public static SubDashboardPage SubDashboardPage()
	{
		return PageFactory.initElements(driver,SubDashboardPage.class);
		
	}
	public static AmKpiPage AmKpiPage()
	{
		return PageFactory.initElements(driver,AmKpiPage.class);
		
	}
	public static CallerPanelPage CallerPanelPage()
	{
		return PageFactory.initElements(driver,CallerPanelPage.class);
		
	}
	public static RequirmentLifeCycle RequirmentLifeCycle()
	{
		return PageFactory.initElements(driver,RequirmentLifeCycle.class);
		
	}
	public static Conversation Conversation()
	{
		return PageFactory.initElements(driver,Conversation.class);
		
	}
	public static Prospective Prospective()
	{
		return PageFactory.initElements(driver,Prospective.class);
		
	}
	public static SMSSendToCandidate SMSSendToCandidate()
	{
		return PageFactory.initElements(driver,SMSSendToCandidate.class);
		
	}
	public static Submission Submission()
	{
		return PageFactory.initElements(driver,Submission.class);
		
	}
	public static SubmissionDetailsPage SubmissionDetailsPage()
	{
		return PageFactory.initElements(driver,SubmissionDetailsPage.class);
		
	}
	public static Shortlisted Shortlisted()
	{
		return PageFactory.initElements(driver,Shortlisted.class);	
	}
	public static Email Email()
	{
		return PageFactory.initElements(driver,Email.class);		
	}
	public static Interview Interview()
	{
		return PageFactory.initElements(driver,Interview.class);
		
	}
	public static OfferReceived OfferReceived()
	{
		return PageFactory.initElements(driver,OfferReceived.class);
		
	}
	public static OfferAccepted OfferAccepted()
	{
		return PageFactory.initElements(driver,OfferAccepted.class);
		
	}
	public static CandidateDetailPage CandidateDetailPage()
	{
		return PageFactory.initElements(driver,CandidateDetailPage.class);
		
	}
}
