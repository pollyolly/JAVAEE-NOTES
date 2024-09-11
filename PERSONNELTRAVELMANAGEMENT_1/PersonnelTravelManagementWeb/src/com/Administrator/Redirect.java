package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.ApprovingOfficerDa;
import com.TravelDa.CardInformationDa;
import com.TravelDa.CashAdvanceDa;
import com.TravelDa.CompanyPolicyDa;
import com.TravelDa.CurrencyDa;
import com.TravelDa.DepartmentDa;
import com.TravelDa.DestinationDa;
import com.TravelDa.EmployeeDa;
import com.TravelDa.ExpenseCategoryDa;
import com.TravelDa.PositionDa;
import com.TravelDa.ServiceProviderDa;
import com.TravelDa.ServicesDa;
import com.TravelDa.StatusDa;
import com.TravelDa.SupportDocumentDa;
import com.TravelDa.TravelExpenseDa;
import com.TravelDa.TravelOrderDa;
import com.TravelDa.TravelPlanDa;
import com.TravelDa.UserManagementDa;
import com.TravelEntity.ApprovingOfficerEntity;
import com.TravelEntity.CardInformationEntity;
import com.TravelEntity.CashAdvanceEntity;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.CurrencyEntity;
import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.DestinationEntity;
import com.TravelEntity.EmployeeEmergencyContactEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.EmployeePassportEntity;
import com.TravelEntity.ExpenseCategoryEntity;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.ServiceProviderEntity;
import com.TravelEntity.ServicesEntity;
import com.TravelEntity.StatusEntity;
import com.TravelEntity.SupportDocumentEntity;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelExpenseListEntity;
import com.TravelEntity.TravelOrderEntity;
import com.TravelEntity.TravelPlanEntity;
import com.TravelEntity.TravelPlanListEntity;
import com.TravelEntity.UserManagementEntity;

/**
 * Servlet implementation class UserManagementDisplay
 */
@WebServlet("/Redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher rd;
 	private String servlet;
 	private StatusDa Status;
 	private EmployeeDa Employee;
 	private PositionDa Position;
 	private DepartmentDa Department;
 	private TravelOrderDa toda;
 	private CashAdvanceDa CADA;
 	private ServiceProviderDa SPDa;
 	private TravelPlanDa TPDa;
 	private TravelExpenseDa TEDa;
 	private CurrencyDa currencyda;
 	private DestinationDa DestDa;
 	private CardInformationDa cardda;
 	private ServicesDa SDa;
 	private SupportDocumentDa SpDa;
 	private CurrencyDa DaCurrency;
 	private ArrayList<StatusEntity> Statuslist;
 	private ArrayList<EmployeeInformationEntity> Employeelist;
 	private ArrayList<DepartmentEntity> Departmentlist;
 	private ArrayList<PositionEntity> Positionlist;
 	private ArrayList<TravelOrderEntity> TravelOrderlist, Destinationlist, Prioritylist, TOCashadvancelist;
 	private ArrayList<CashAdvanceEntity> Cashadvancelist;
 	private ArrayList<ServiceProviderEntity> splist;
 	private ArrayList<TravelPlanEntity> planlist;
 	private String tno, odid;
 	 private String alertStatus="";
     private String message = "";
     private String planid;
     private CompanyPolicyDa DaPolicy;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
    	cardda = new CardInformationDa();
    	DestDa = new DestinationDa();
    	 Employee = new EmployeeDa();
    	Status = new StatusDa();
    	Position = new PositionDa();
    	Department = new DepartmentDa();
    	 toda = new TravelOrderDa();
    	 CADA = new CashAdvanceDa();
    	SPDa = new ServiceProviderDa();
    	TPDa = new TravelPlanDa();
    	TEDa = new TravelExpenseDa();
    	currencyda = new CurrencyDa();
    	SDa = new ServicesDa();
    	SpDa = new SupportDocumentDa();
    	DaCurrency = new CurrencyDa();
    	DaPolicy = new CompanyPolicyDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		alertStatus = request.getParameter("alertStatus");
		message = request.getParameter("message");
		servlet = request.getParameter("servletpage");
		switch(servlet){
		case "EmergencyContact":
			EmergencyContact(request, response);
			break;
		case "SupportDocument":
			SupportDocument(request, response);
			break;
		case "TravelExpensePersonnel":
			TravelExpensePersonnel(request, response);
			break;
		case "TravelExpenseListPersonnel":
			TravelExpenseListPersonnel(request, response);
			break;
		case "TravelExpenseOfficer":
			TravelExpenseOfficer(request, response);
			break;
		case "TravelPlanOfficer":
			TravelPlanOfficer(request, response);
			break;
		case "CashAdvanceOfficer":
			CashAdvanceOfficer(request, response);
			break;
		case "TravelOrderOfficer":
			TravelOrderOfficer(request, response);
			break;
		case "Services":
			Services(request, response);
			break;
		case "Destination":
			Destination(request, response);
			break;
		case "Currency":
			Currency(request, response);
			break;
		case "Position":
			PositionList(request, response);
			break;
		case "CardInformation":
			CardInformationList(request, response);
			break;
		case "EmployeeInformation":
			EmployeeInformation(request, response);
			break;
		case "EmployeePassport":
			EmployeePassport(request, response);
			break;
		case "EmployeeEmergencyContact":
			EmployeeList(request, response);
			break;
		case "ExpenseCategory":
			ExpenseCategoryList(request, response);
			break;
		case "CompanyPolicy":
			CompanyPolicyList(request, response);
			break;
		case "UserManagement":
			UserManagementList(request, response);
			break;
		case "Department":
			DepartmentList(request, response);
			break;
		case "ApprovingOfficer":
			ApprovingOfficerlist(request, response);
			break;
		case "TravelOrder":
			TravelOrder(request, response);
			break;
		case "CashAdvance":
			CashAdvancelist(request, response);
			break;
		case "TravelPlan":
			TravelPlan(request, response);
			break;
		case "ServiceProvider":
			ServiceProviderlist(request, response);
			break;
		case "TravelPlanList":
			tno = request.getParameter("tnos");
			planid = request.getParameter("tpid");
			TravelPlanList(request, response);
			break;
		case "TravelExpense":
			tno = request.getParameter("tnos");
			TravelExpense(request, response);
			break;
		case "TravelExpenseList":
			odid = request.getParameter("odid");
			TravelExpenseList(request, response);
			break;
		}
	}

	protected void EmployeePassport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<EmployeePassportEntity> passlist;
		ArrayList<EmployeeInformationEntity> emplist;
		ArrayList<StatusEntity>statlist = Status.getStatus();
		passlist = Employee.getEmployeePassportList();
		emplist = Employee.getEmployee();
			request.setAttribute("statlist", statlist);
			request.setAttribute("emplist", emplist);
			request.setAttribute("passlist", passlist);
			rd = request.getRequestDispatcher("S-EmployeePassport.jsp");
			rd.include(request, response);
	}
	
	protected void EmergencyContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity> statuslist=null;
		ArrayList<EmployeeEmergencyContactEntity>emerlist = null;
		ArrayList<EmployeeInformationEntity>emp =null;
		emp = Employee.getEmployee();
		statuslist = Status.getStatus();
		emerlist = Employee.getEmployeeContactList();
			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("emerlist", emerlist);
			request.setAttribute("empList", emp);
			request.setAttribute("statList", statuslist);
			rd = request.getRequestDispatcher("S-EmployeeEmergencyContact.jsp");
			rd.include(request, response);
		System.out.print("Empty list");
	}
	
	protected void SupportDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Statuslist = Status.getStatus();
		TravelOrderlist = toda.getTOno();
		ArrayList<SupportDocumentEntity> doclist = SpDa.getSupportDocument();
		//request.setAttribute("statlist", Statuslist);
		request.setAttribute("tolist", TravelOrderlist);
		request.setAttribute("doclist", doclist);
		rd = request.getRequestDispatcher("T-Supportdocument.jsp");
		rd.include(request, response);
	}
	
	protected void TravelExpensePersonnel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelExpenseEntity> expenselist=null;
		expenselist = TEDa.getTravelExpense();
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-TravelexpensePersonnel.jsp");
		rd.include(request, response);
	}
	
	protected void TravelExpenseListPersonnel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelExpenseEntity> travelexpense = null;
		ArrayList<TravelExpenseListEntity> travelexpenselist = null;
		ArrayList<CurrencyEntity> currencylist = null;
		currencylist = DaCurrency.getCurrencyList();
		odid = request.getParameter("odid");
		travelexpense = TEDa.getTravelExpenseByOrderId(Integer.valueOf(odid));
		travelexpenselist = TEDa.getTravelExpenseListByOrderId(Integer.valueOf(odid));
		request.setAttribute("currencylist", currencylist);
		request.setAttribute("travelexpense", travelexpense);
		request.setAttribute("travelexpenselist", travelexpenselist);
		rd = request.getRequestDispatcher("T-TravelexpenselistPersonnel.jsp");
		rd.include(request, response);
	}
	
	protected void TravelExpenseOfficer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TEDa = new TravelExpenseDa();
		ArrayList<TravelExpenseEntity> expenselist=null;
		expenselist = TEDa.getTravelExpense();
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-TravelexpenseOfficer.jsp");
		rd.include(request, response);	
	}
	protected void TravelPlanOfficer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		planlist = TPDa.getTravelPlanList();
		request.setAttribute("planlist", planlist);
		rd = request.getRequestDispatcher("T-TravelplanOfficer.jsp");
		rd.include(request, response);
	}
	protected void CashAdvanceOfficer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cashadvancelist = CADA.getCashAdvanceList();
			request.setAttribute("calist", Cashadvancelist);
			rd = request.getRequestDispatcher("T-CashadvanceOfficer.jsp");
			rd.include(request, response);
	
	}
	protected void TravelOrderOfficer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelOrderlist =  toda.getTravelOrderList();
		request.setAttribute("travelorderlist", TravelOrderlist);
		rd = request.getRequestDispatcher("T-TravelorderOfficer.jsp");
		rd.include(request, response);
	}
	protected void Services(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StatusEntity> statuslist;
		ArrayList<ServiceProviderEntity> splist;
		ArrayList<ServicesEntity> svlist, svtype, svclass;
		splist = SPDa.getServiceProviderList();
		svtype = SDa.getServicesType();
		svclass = SDa.getServicesClass();
		svlist = SDa.getServicesList();
		statuslist =  Status.getStatus();
		request.setAttribute("statuslist", statuslist);
		request.setAttribute("splist", splist);
		request.setAttribute("svtype", svtype);
		request.setAttribute("svclass", svclass);
		request.setAttribute("svlist", svlist);
		rd = request.getRequestDispatcher("S-Services.jsp");
		rd.include(request, response);
	}
	
	protected void Destination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StatusEntity>statlist = null;
		ArrayList<DestinationEntity>destlist = null;
				statlist = Status.getStatus();
				destlist = DestDa.getDestinationList();

					request.setAttribute("message", message);
					request.setAttribute("alertStatus", alertStatus);
					request.setAttribute("statlist", statlist);
					request.setAttribute("destlist", destlist);
					rd = request.getRequestDispatcher("C-Destination.jsp");
					rd.include(request, response);
				
	}
	
	protected void Currency(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StatusEntity>statlist = null;
		ArrayList<CurrencyEntity>currencylist = null;
				statlist = Status.getStatus();
				currencylist = currencyda.getCurrencyList();

					request.setAttribute("statlist", statlist);
					request.setAttribute("currencylist", currencylist);
					rd = request.getRequestDispatcher("C-Currency.jsp");
					rd.include(request, response);
				
	}
	
	protected void TravelExpense(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<TravelExpenseEntity> expenselist=null;
		ArrayList<TravelOrderEntity> tonolist=null;
		tonolist = toda.getTOno();
		expenselist = TEDa.getTravelExpense();
		request.setAttribute("tolist", tonolist);
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-Travelexpense.jsp");
		rd.include(request, response);
	}
	protected void TravelExpenseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TravelExpenseEntity> travelexpense = null;
		ArrayList<TravelExpenseListEntity> travelexpenselist = null;
		ArrayList<CurrencyEntity> currencylist = null;
		currencylist = DaCurrency.getCurrencyList();
		travelexpense = TEDa.getTravelExpenseByOrderId(Integer.valueOf(odid));
		travelexpenselist = TEDa.getTravelExpenseListByOrderId(Integer.valueOf(odid));
		request.setAttribute("currencylist", currencylist);
		request.setAttribute("travelexpense", travelexpense);
		request.setAttribute("travelexpenselist", travelexpenselist);
		rd = request.getRequestDispatcher("T-Travelexpenselist.jsp");
		rd.include(request, response);
	}
	
	protected void TravelPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TravelPlanEntity> planlist;
	    ArrayList<TravelOrderEntity> tonolist;
		tonolist = toda.getTOno();
		planlist = TPDa.getTravelPlanList();
		request.setAttribute("tolist", tonolist);
		request.setAttribute("planlist", planlist);
		rd = request.getRequestDispatcher("T-Travelplan.jsp");
		rd.include(request, response);
	}
	protected void TravelPlanList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelPlanEntity> travelplanbytono=null;
		ArrayList<TravelPlanListEntity> travelplanlist;
		ArrayList<ServiceProviderEntity> splist;
		splist = SPDa.getServiceProviderList();
		ArrayList<CompanyPolicyEntity> policylist = null;
		policylist = DaPolicy.getPolicy();
		travelplanbytono = TPDa.getTravelPlan(tno, planid);
		travelplanlist = TPDa.getTravelPlanListByToNo(tno, planid);
		String names="";
		for(int i=0; travelplanbytono.size() > i; i++){
			TravelPlanEntity data = travelplanbytono.get(i);
			names += data.getName()+", ";
		}
		request.setAttribute("policylist", policylist);
		request.setAttribute("names", names);
		request.setAttribute("plan", travelplanbytono);
		request.setAttribute("planlist", travelplanlist);
		request.setAttribute("splist", splist);	
		rd = request.getRequestDispatcher("T-Travelplanlist.jsp");
		rd.include(request, response);
	}
	protected void ServiceProviderlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity> statuslist =  Status.getStatus();
		splist = SPDa.getServiceProvider();

			request.setAttribute("statuslist", statuslist);
			request.setAttribute("splist", splist);
			rd = request.getRequestDispatcher("S-Serviceprovider.jsp");
			rd.include(request, response);

	}
	
	protected void CashAdvancelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cashadvancelist = CADA.getCashAdvanceList();
		TOCashadvancelist = toda.getTOno();

			request.setAttribute("tolist", TOCashadvancelist);
			request.setAttribute("calist", Cashadvancelist);
			rd = request.getRequestDispatcher("T-Cashadvance.jsp");
			rd.include(request, response);

	}
	protected void TravelOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Destinationlist = toda.getDestination();
		Prioritylist = toda.getPriority();
		TravelOrderlist =  toda.getTravelOrderList();
		Employeelist = Employee.getEmployee();

			request.setAttribute("prioritylist", Prioritylist);
			request.setAttribute("travelorderlist", TravelOrderlist);
			request.setAttribute("employeelist", Employeelist);
			request.setAttribute("destinationlist", Destinationlist);
			rd = request.getRequestDispatcher("T-Travelorder.jsp");
			rd.include(request, response);

	}
	protected void EmployeeInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statuslist = Status.getStatus();
		Positionlist = Position.getPosition();
		Departmentlist = Department.getDepartment();
		Employeelist = Employee.getAllEmployeeInformation();

			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("jspstatlist", Statuslist);
			request.setAttribute("jspdeptlist", Departmentlist);
			request.setAttribute("jspemplist", Employeelist);
			request.setAttribute("jsppostlist", Positionlist);
			rd = request.getRequestDispatcher("S-EmployeeInformation.jsp");
			rd.include(request, response);

	}
	
	protected void PositionList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statuslist =  Status.getStatus();
		Positionlist = Position.getAllPositionList();

			request.setAttribute("jspStatuslist", Statuslist);
			request.setAttribute("jspPositionlist", Positionlist);
			rd = request.getRequestDispatcher("S-Position.jsp");
			rd.include(request, response);

	}
	
	protected void CardInformationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CardInformationEntity> ownlist, cardtyplist, cardinfolist;
		ArrayList<StatusEntity>statlist = Status.getStatus();
		ArrayList<EmployeeInformationEntity> emplist = Employee.getEmployee();
		cardinfolist = cardda.getAllCardInformationList();
		ownlist = cardda.getOwnershipList();
		cardtyplist = cardda.getCardtypeList();

			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("Statlist", statlist);
			request.setAttribute("Emplist", emplist);
			request.setAttribute("Cardinfolist", cardinfolist);
			request.setAttribute("ownlist", ownlist);
			request.setAttribute("cardtyplist", cardtyplist);
			rd = request.getRequestDispatcher("C-Cardinformation.jsp");
			rd.include(request, response);
		
	}
	
	protected void EmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statuslist = Status.getStatus();
		Positionlist = Position.getPosition();
		Departmentlist = Department.getDepartment();
		Employeelist = Employee.getAllEmployeeInformation();

			request.setAttribute("jspstatlist", Statuslist);
			request.setAttribute("jspdeptlist", Departmentlist);
			request.setAttribute("jspemplist", Employeelist);
			request.setAttribute("jsppostlist", Positionlist);
			rd = request.getRequestDispatcher("S-EmployeeInformation.jsp");
			rd.include(request, response);

	}
	
	protected void ExpenseCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ExpenseCategoryEntity> Alllist;
		ExpenseCategoryDa data = new ExpenseCategoryDa();
		Alllist =  data.getAllExpenseCategory();
		Departmentlist = Department.getDepartment();
		Statuslist = Status.getStatus();

			request.setAttribute("jspAlllist", Alllist);
			request.setAttribute("jspStatlist", Statuslist);
			request.setAttribute("jspDeptlist", Departmentlist);
			rd = request.getRequestDispatcher("C-Expensecategory.jsp");
			rd.include(request, response);
	}
	
	protected void CompanyPolicyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CompanyPolicyEntity> alllist;
		CompanyPolicyDa data = new CompanyPolicyDa();
		Statuslist = Status.getStatus();
		Departmentlist = Department.getDepartment();
		alllist = data.getAllCompanyPolicyList();
			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("statuslist", Statuslist);
			request.setAttribute("departmentlist", Departmentlist);
			request.setAttribute("policylist", alllist);
			rd = request.getRequestDispatcher("C-Companypolicy.jsp");
			rd.include(request, response);
	}
	protected void ApprovingOfficerlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ApprovingOfficerEntity>  Alllist;
		ApprovingOfficerDa data = new ApprovingOfficerDa();
		Statuslist = Status.getStatus();
		Employeelist = Employee.getEmployee();
		Alllist = data.getAllApprovingOfficer();

			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("employeelist", Employeelist);
			request.setAttribute("statuslist", Statuslist);
			request.setAttribute("alllist", Alllist);
			rd = request.getRequestDispatcher("C-Approvingofficer.jsp");
			rd.include(request, response);

	}
	
	
	protected void UserManagementList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<UserManagementEntity> acc, role;
		UserManagementDa data = new UserManagementDa();
		acc = data.getAllAccount();
		Employeelist = Employee.getEmployee();
		role = data.getRoleList();
		Statuslist = Status.getStatus();
			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("accList", acc);
			request.setAttribute("empList", Employeelist);
			request.setAttribute("roleList", role);
			request.setAttribute("statList", Statuslist);
			rd = request.getRequestDispatcher("C-Usermanagement.jsp");
		    rd.include(request, response);

	}
	protected void DepartmentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<DepartmentEntity> deptlist;
		DepartmentDa data = new DepartmentDa();
		deptlist = data.getAllDepartment();
		Statuslist = Status.getStatus();
			request.setAttribute("deptlist", deptlist);
			request.setAttribute("statlist", Statuslist);
			rd = request.getRequestDispatcher("S-Department.jsp");
			rd.include(request, response);

	}
}
