/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2016-03-24 18:33:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class R_002dExpenseanalytical_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/_Footer.jsp", Long.valueOf(1454334186743L));
    _jspx_dependants.put("/_Sidebar.jsp", Long.valueOf(1458813589662L));
    _jspx_dependants.put("/_Topbar.jsp", Long.valueOf(1441982158000L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>Report-Expense Analytical</title>\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\t<meta name=\"description\" content=\"Avant\">\r\n");
      out.write("\t<meta name=\"author\" content=\"The Red Team\">\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"assets/css/styles.css?=121\">\r\n");
      out.write("\t<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='styleswitcher'> \r\n");
      out.write("\t<link href='assets/demo/variations/default.css' rel='stylesheet' type='text/css' media='all' id='headerswitcher'> \r\n");
      out.write("\t \r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/plugins/charts-morrisjs/morris.css'/> \r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/plugins/form-select2/select2.css' /> \r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/plugins/codeprettifier/prettify.css' /> \r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/plugins/form-toggle/toggles.css' /> \r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/css/custom.css'/>\r\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='assets/fonts/glyphicons/css/glyphicons.min.css' /> \r\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"assets/js/less.js\"></script> -->\r\n");
      out.write("\t<link rel='shortcut icon' href='assets/img/BPS_LOGO.png' type='image/jpeg' style=\"width: 16px; height: 16px;\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"\">\r\n");
      out.write("\r\n");
      out.write("<header class=\"navbar navbar-inverse navbar-fixed-top\" role=\"banner\">\r\n");
      out.write("        <a id=\"leftmenu-trigger\" class=\"tooltips\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Toggle Sidebar\"></a>\r\n");
      out.write("        <!--a id=\"rightmenu-trigger\" class=\"tooltips\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Toggle Infobar\">\r\n");
      out.write("        RIGHT BAR NAV\r\n");
      out.write("        </a-->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"navbar-header pull-left\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav navbar-nav pull-right toolbar\">\r\n");
      out.write("\r\n");
      out.write("        \t<li class=\"dropdown\">\r\n");
      out.write("        \t\t<a href=\"#\" class=\"dropdown-toggle username\" data-toggle=\"dropdown\"><span class=\"hidden-xs\">John McCartney <i class=\"fa fa-caret-down\"></i></span><img src=\"assets/demo/avatar/dangerfield.png\" alt=\"Dangerfield\" /></a>\r\n");
      out.write("        \t\t<ul class=\"dropdown-menu userinfo arrow\">\r\n");
      out.write("        \t\t\t<li class=\"username\">\r\n");
      out.write("                        <a href=\"#\">\r\n");
      out.write("        \t\t\t\t    <div class=\"pull-left\"><img class=\"userimg\" src=\"assets/demo/avatar/dangerfield.png\" alt=\"Jeff Dangerfield\"/></div>\r\n");
      out.write("        \t\t\t\t    <div class=\"pull-right\"><h5>Howdy, John!</h5><small>Logged in as <span>john275</span></small></div>\r\n");
      out.write("                        </a>\r\n");
      out.write("        \t\t\t</li>\r\n");
      out.write("        \t\t\t<li class=\"userlinks\">\r\n");
      out.write("        \t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("        \t\t\t\t\t<li><a href=\"#\">Account <i class=\"pull-right fa fa-cog\"></i></a></li>\r\n");
      out.write("        \t\t\t\t\t<li><a href=\"#\">Help <i class=\"pull-right fa fa-question-circle\"></i></a></li>\r\n");
      out.write("        \t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("        \t\t\t\t\t<li><a href=\"#\" class=\"text-right\">Sign Out</a></li>\r\n");
      out.write("        \t\t\t\t</ul>\r\n");
      out.write("        \t\t\t</li>\r\n");
      out.write("        \t\t</ul>\r\n");
      out.write("        \t</li>\r\n");
      out.write("        \t<li class=\"dropdown\">\r\n");
      out.write("        \t\t<a href=\"#\" class=\"hasnotifications dropdown-toggle\" data-toggle='dropdown'><i class=\"fa fa-envelope\"></i><span class=\"badge\">1</span></a>\r\n");
      out.write("        \t\t<ul class=\"dropdown-menu messages arrow\">\r\n");
      out.write("        \t\t\t<li class=\"dd-header\">\r\n");
      out.write("        \t\t\t\t<span>You have 1 new message(s)</span>\r\n");
      out.write("        \t\t\t\t<span><a href=\"#\">Mark all Read</a></span>\r\n");
      out.write("        \t\t\t</li>\r\n");
      out.write("                    <div class=\"scrollthis\">\r\n");
      out.write("    \t\t\t        <li><a href=\"#\" class=\"active\">\r\n");
      out.write("    \t\t\t        \t<span class=\"time\">6 mins</span>\r\n");
      out.write("    \t\t\t        \t<img src=\"assets/demo/avatar/doyle.png\" alt=\"avatar\" />\r\n");
      out.write("    \t\t\t        \t<div><span class=\"name\">Alan Doyle</span><span class=\"msg\">Please mail me the files by tonight.</span></div>\r\n");
      out.write("    \t\t\t        </a></li>\r\n");
      out.write("    \t\t\t        <li><a href=\"#\">\r\n");
      out.write("    \t\t\t        \t<span class=\"time\">12 mins</span>\r\n");
      out.write("    \t\t\t        \t<img src=\"assets/demo/avatar/paton.png\" alt=\"avatar\" />\r\n");
      out.write("    \t\t\t        \t<div><span class=\"name\">Polly Paton</span><span class=\"msg\">Uploaded all the files to server. Take a look.</span></div>\r\n");
      out.write("    \t\t\t        </a></li>\r\n");
      out.write("                    </div>\r\n");
      out.write("        \t\t\t<li class=\"dd-footer\"><a href=\"Messages.jsp\">View All Messages</a></li>\r\n");
      out.write("        \t\t</ul>\r\n");
      out.write("        \t</li>\r\n");
      out.write("            <li><a href=\"#\" title=\"Email\"><i class=\"glyphicon glyphicon-send\"></i></a></li>\r\n");
      out.write("        \t<!--li class=\"dropdown\">\r\n");
      out.write("        \t\t<a href=\"#\" class=\"hasnotifications dropdown-toggle\" data-toggle='dropdown' id=\"woo\"><i class=\"fa fa-bell\"></i><span class=\"badge\">3</span></a>\r\n");
      out.write("        \t\t<ul class=\"dropdown-menu notifications arrow\" id=\"woo2\">\r\n");
      out.write("        \t\t\t<li class=\"dd-header\">\r\n");
      out.write("        \t\t\t\t<span>You have 3 new notification(s)</span>\r\n");
      out.write("        \t\t\t\t<span><a href=\"#\">Mark all Seen</a></span>\r\n");
      out.write("        \t\t\t</li>\r\n");
      out.write("                    <div class=\"scrollthis\">\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-user active\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">4 mins</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-user\"></i>\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">New user Registered. </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-danger active\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">20 mins</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-bolt\"></i>\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">CPU at 92% on server#3! </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-success active\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">1 hr</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-check\"></i> \r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">Server#1 is live. </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-warning\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">2 hrs</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-exclamation-triangle\"></i> \r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">Database overloaded. </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-order\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">10 hrs</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-shopping-cart\"></i> \r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">New order received. </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-failure\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">12 hrs</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-times-circle\"></i>\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">Application error!</span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-fix\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">12 hrs</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-wrench\"></i>\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">Installation Succeeded.</span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("    \t\t\t\t    <li>\r\n");
      out.write("    \t\t\t\t    \t<a href=\"#\" class=\"notification-success\">\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"time\">18 hrs</span>\r\n");
      out.write("    \t\t\t\t    \t\t<i class=\"fa fa-check\"></i>\r\n");
      out.write("    \t\t\t\t    \t\t<span class=\"msg\">Account Created. </span>\r\n");
      out.write("    \t\t\t\t    \t</a>\r\n");
      out.write("    \t\t\t\t    </li>\r\n");
      out.write("                    </div>\r\n");
      out.write("        \t\t\t<li class=\"dd-footer\"><a href=\"#\">View All Notifications</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</li-->\r\n");
      out.write("            <!--li> Header Dropdown\r\n");
      out.write("                <a href=\"#\" id=\"headerbardropdown\"><span><i class=\"fa fa-level-down\"></i></span></a>\r\n");
      out.write("            </li-->\r\n");
      out.write("            <li class=\"dropdown demodrop\">\r\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle tooltips\" data-toggle=\"dropdown\"><i class=\"fa fa-cogs\"></i></a>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"dropdown-menu arrow dropdown-menu-form\" id=\"demo-dropdown\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <label for=\"demo-header-variations\" class=\"control-label\">Header Colors</label>\r\n");
      out.write("                        <ul class=\"list-inline demo-color-variation\" id=\"demo-header-variations\">\r\n");
      out.write("                            <li><a class=\"color-black\" href=\"javascript:;\"  data-headertheme=\"header-black.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-dark\" href=\"javascript:;\"  data-headertheme=\"default.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-red\" href=\"javascript:;\" data-headertheme=\"header-red.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-blue\" href=\"javascript:;\" data-headertheme=\"header-blue.css\"></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <label for=\"demo-color-variations\" class=\"control-label\">Sidebar Colors</label>\r\n");
      out.write("                        <ul class=\"list-inline demo-color-variation\" id=\"demo-color-variations\">\r\n");
      out.write("                            <li><a class=\"color-lite\" href=\"javascript:;\"  data-theme=\"default.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-steel\" href=\"javascript:;\" data-theme=\"sidebar-steel.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-lavender\" href=\"javascript:;\" data-theme=\"sidebar-lavender.css\"></a></li>\r\n");
      out.write("                            <li><a class=\"color-green\" href=\"javascript:;\" data-theme=\"sidebar-green.css\"></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <label for=\"fixedheader\">Fixed Header</label>\r\n");
      out.write("                        <div id=\"fixedheader\" style=\"margin-top:5px;\"></div> \r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("    </header>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"page-container\">\r\n");
      out.write("        <!-- BEGIN SIDEBAR -->\r\n");
      out.write("         ");
      out.write("<nav id=\"page-leftbar\" role=\"navigation\">\r\n");
      out.write("                <!-- BEGIN SIDEBAR MENU -->\r\n");
      out.write("            <ul class=\"acc-menu\" id=\"sidebar\">\r\n");
      out.write("                <div><img class=\"logo\" src=\"assets/img/BPS_LOGO.png\" title=\"Business Productivity Solution\"></div>\r\n");
      out.write("                <li id=\"search\">\r\n");
      out.write("                    <a href=\"#\"><i class=\"fa fa-search opacity-control\"></i></a>\r\n");
      out.write("                     <form>\r\n");
      out.write("                        <!--input type=\"text\" class=\"search-query\" placeholder=\"Search...\">\r\n");
      out.write("                        <button type=\"submit\"><i class=\"fa fa-search\"></i></button-->\r\n");
      out.write("                    </form>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"divider\"></li>\r\n");
      out.write("                <li><a href=\"Dashboard\"><i class=\"fa fa-home\"></i> <span>Dashboard</span></a></li>\r\n");
      out.write("                <li class=\"divider\"></li>\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-cog\"></i> <span>Configuration Management</span></a>\r\n");
      out.write("                    <ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"UserManagement\">User Management</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"ApprovingOfficer\">Approving Officer</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"CompanyPolicy\">Company Policy</a></li>\r\n");
      out.write("\t\t\t\t\t <li><a href=\"Currency\">Currency</a></li>\r\n");
      out.write("\t\t\t\t\t <li><a href=\"Destination\">Destination</a></li>\r\n");
      out.write("\t\t\t\t\t <li><a href=\"CardInformation\">Credit/Visa Card</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"C-Systemlog.jsp\">System Logs</a></li>\r\n");
      out.write("\t\t\t\t\t<!--li><a href=\"C-Import.jsp\">Import</a></li-->\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                \r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-wrench\"></i> <span>Data-Builder</span></a>\r\n");
      out.write("                    <ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Employee</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"EmployeeInformation\">Employee Information</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"EmployeeEmergencyContact\">Emergency Contact</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"EmployeePassport\">Passport</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Department\">Department</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Position\">Position</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"ServiceProvider\">Service Provider</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Services\">Services</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-pencil-square-o\"></i> <span>Transaction</span></a>\r\n");
      out.write("                    <ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"TravelOrder\">Travel Order</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"CashAdvance\">Cash Advance</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"TravelPlan\">Travel Plan</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"TravelExpense\">Travel Expense</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"SupportDocument\">Support Document</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-list\"></i> <span>Query</span></a>\r\n");
      out.write("                    <ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Userlist.jsp\">User List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Employoeelist.jsp\">Employee List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Approvingofficerlist.jsp\">Approving Officer List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Departmentlist.jsp\">Department List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Serviceproviderlist.jsp\">ServiceProvider List</a></li>\r\n");
      out.write("\t\t\t\t\t<!--li><a href=\"Q-Serviceslist.jsp\">Services List</a></li-->\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Hotellist.jsp\">Hotel List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Airlinelist.jsp\">Airline List</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Q-Carrentallist.jsp\">Car Rental List</a></li>\r\n");
      out.write("                        \r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-book\"></i> <span>Report</span></a>\r\n");
      out.write("                    <ul class=\"acc-menu\">\r\n");
      out.write("                        <li><a href=\"TravelOrderReport\">Travel Order Report</a></li>\r\n");
      out.write("                        <li><a href=\"CashAdvanceReport\">Travel CashAdvance Report</a></li>\r\n");
      out.write("                        <li><a href=\"TravelPlanReport\">Travel Plan Report</a></li>\r\n");
      out.write("                        <li><a href=\"TravelExpenseReport\">Travel Expense Report</a></li>\r\n");
      out.write("                        <li><a href=\"TravelBudgetReport\">Travel Budget Report</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Travel Analytical Report</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"acc-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"R-Expenseanalytical.jsp\">Expense Analytical Report</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"R-Travelanalytical.jsp\">Travel Analytical Report</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"divider\"></li>\r\n");
      out.write("                <li><a href=\"Messages.jsp\"><i class=\"fa fa-envelope\"></i><span>Messages</span></a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <!-- END SIDEBAR MENU -->\r\n");
      out.write("        </nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"page-content\">\r\n");
      out.write("        <div id='wrap'>\r\n");
      out.write("            <div id=\"page-heading\">\r\n");
      out.write("                <ol class=\"breadcrumb\">\r\n");
      out.write("                    <li><a href=\"index.htm\">Dashboard</a></li>\r\n");
      out.write("                    <li>Report</li>\r\n");
      out.write("                    <li><b>Expense Analytical</b></li>\r\n");
      out.write("                </ol>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t<div class=\"panel panel-primary\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("                          <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"focusedinput\" class=\"col-xs-2 control-label\">Department:</label>\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                            <select name=\"department\" id=\"department\" style=\"width:100%;\">\r\n");
      out.write("                                <option>Search...</option>\r\n");
      out.write("                                <option>Department One</option>\r\n");
      out.write("                                <option>Department Two</option>\r\n");
      out.write("                                <option>Deartment Three</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("                            <label for=\"focusedinput\" class=\"col-xs-2 control-label\">Personnel:</label>\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                            <select name=\"personnel\" id=\"personnel\" style=\"width:100%;\">\r\n");
      out.write("                                <option>Search...</option>\r\n");
      out.write("                                <option>Department One</option>\r\n");
      out.write("                                <option>Department Two</option>\r\n");
      out.write("                                <option>Deartment Three</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("                            <label for=\"focusedinput\" class=\"col-xs-2 control-label\">Destination:</label>\r\n");
      out.write("                            <div class=\"col-xs-3\">\r\n");
      out.write("                            <select name=\"destination\" id=\"destination\" style=\"width:100%;\">\r\n");
      out.write("                                <option>Search...</option>\r\n");
      out.write("                                <option>Department One</option>\r\n");
      out.write("                                <option>Department Two</option>\r\n");
      out.write("                                <option>Deartment Three</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("                            <label class=\"col-xs-2 control-label\">FromDate:</label>\r\n");
      out.write("                                <div class=\"col-xs-3\">\r\n");
      out.write("                                    <div class=\"input-group date\" id=\"fromdate\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\">\r\n");
      out.write("                                        <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"col-xs-2 control-label\">ToDate:</label>\r\n");
      out.write("                                <div class=\"col-xs-3\">\r\n");
      out.write("                                    <div class=\"input-group date\" id=\"todate\">\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\">\r\n");
      out.write("                                        <span class=\"input-group-addon\"><i class=\"fa fa-calendar\"></i></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12 col-lg-12\">\r\n");
      out.write("                        <div class=\"panel panel-primary\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h4>Expense Analytical Report</h4>\r\n");
      out.write("                                <div class=\"options\">   \r\n");
      out.write("                                    <!--a href=\"javascript:;\"><i class=\"fa fa-cog\"></i></a-->\r\n");
      out.write("                                    <a href=\"javascript:;\" class=\"panel-collapse\"><i class=\"fa fa-chevron-down\"></i></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <div id=\"line-example\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- container -->\r\n");
      out.write("        </div> <!--wrap -->\r\n");
      out.write("    </div> <!-- page-content -->\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("<footer role=\"contentinfo\">\r\n");
      out.write("        <div class=\"clearfix\">\r\n");
      out.write("            <ul class=\"list-unstyled list-inline\">\r\n");
      out.write("                <li>BPS | Personnel Travel Management System &copy; ");
      out.print( new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) );
      out.write("</li>\r\n");
      out.write("                <button class=\"pull-right btn btn-inverse-alt btn-xs hidden-print\" id=\"back-to-top\"><i class=\"fa fa-arrow-up\"></i></button>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div> <!-- page-container -->\r\n");
      out.write("\r\n");
      out.write("<script type='text/javascript' src='assets/js/jquery-1.10.2.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/jqueryui-1.10.3.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/bootstrap.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/enquire.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/jquery.cookie.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/jquery.nicescroll.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/codeprettifier/prettify.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/easypiechart/jquery.easypiechart.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/sparklines/jquery.sparklines.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/form-toggle/toggle.min.js'></script>  \r\n");
      out.write("<script type='text/javascript' src='assets/js/placeholdr.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/js/application.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/demo/demo.js'></script>\r\n");
      out.write("<!--MORRIS--> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/form-select2/select2.min.js'></script>\r\n");
      out.write("<script type='text/javascript' src='assets/plugins/form-datepicker/js/bootstrap-datepicker.js'></script>\r\n");
      out.write("<script type='text/javascript' src='assets/plugins/charts-morrisjs/morris.min.js'></script> \r\n");
      out.write("<script type='text/javascript' src='assets/plugins/charts-morrisjs/raphael.min.js'></script> \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("$('#fromdate').datepicker({}),\r\n");
      out.write("$('#todate').datepicker({}),\r\n");
      out.write("$('#department').select2(),\r\n");
      out.write("$('#destination').select2(),\r\n");
      out.write("$('#personnel').select2(),\r\n");
      out.write("Morris.Line({\r\n");
      out.write("        element: 'line-example',\r\n");
      out.write("        data: [\r\n");
      out.write("            { y: '2006', a: 100, b: 90 },\r\n");
      out.write("            { y: '2007', a: 75,  b: 65 },\r\n");
      out.write("            { y: '2008', a: 50,  b: 40 },\r\n");
      out.write("            { y: '2009', a: 75,  b: 65 },\r\n");
      out.write("            { y: '2010', a: 50,  b: 40 },\r\n");
      out.write("            { y: '2011', a: 75,  b: 65 },\r\n");
      out.write("            { y: '2012', a: 100, b: 90 }\r\n");
      out.write("        ],\r\n");
      out.write("        xkey: 'y',\r\n");
      out.write("        ykeys: ['a', 'b'],\r\n");
      out.write("        labels: ['Series A', 'Series B']\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
