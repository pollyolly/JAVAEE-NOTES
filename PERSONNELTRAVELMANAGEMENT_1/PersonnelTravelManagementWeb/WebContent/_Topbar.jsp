<header class="navbar navbar-inverse navbar-fixed-top" role="banner">
        <a id="leftmenu-trigger" class="tooltips" data-toggle="tooltip" data-placement="right" title="Toggle Sidebar"></a>
        <!--a id="rightmenu-trigger" class="tooltips" data-toggle="tooltip" data-placement="left" title="Toggle Infobar">
        RIGHT BAR NAV
        </a-->

        <div class="navbar-header pull-left" style="margin-top:10px;">
             <span style="font-size:18px; color:white;" >&nbsp;BPS - PTMS</span>
        </div>

        <ul class="nav navbar-nav pull-right toolbar">
        	<li class="dropdown">
        		<a href="#" class="dropdown-toggle username" data-toggle="dropdown"><span class="hidden-xs">${sessionScope.employee} <i class="fa fa-caret-down"></i></span><img src="assets/demo/avatar/dangerfield.png" alt="Dangerfield" /></a>
        		<ul class="dropdown-menu userinfo arrow">
        			<li class="username">
                        <a href="#">
        				    <div class="pull-left"><img class="userimg" src="assets/demo/avatar/dangerfield.png" alt="${sessionScope.employee}"/></div>
        				    <div class="pull-right"><h5>${sessionScope.employee}</h5><small>Logged in as <span>${sessionScope.username}</span></small></div>
                        </a>
        			</li>
        			<li class="userlinks">
        				<ul class="dropdown-menu">
        					<!--li><a href="#">Account <i class="pull-right fa fa-cog"></i></a></li>
        					<li><a href="#">Help <i class="pull-right fa fa-question-circle"></i></a></li>
        					<li class="divider"></li-->
        					<li><a href="Authentication?logout=logout" class="text-right">Sign Out</a></li>
        				</ul>
        			</li>
        		</ul>
        	</li>
        	<!--li class="dropdown">
        		<a href="#" class="hasnotifications dropdown-toggle" data-toggle='dropdown'><i class="fa fa-envelope"></i><span class="badge">1</span></a>
        		<ul class="dropdown-menu messages arrow">
        			<li class="dd-header">
        				<span>You have 1 new message(s)</span>
        				<span><a href="#">Mark all Read</a></span>
        			</li>
                    <div class="scrollthis">
    			        <li><a href="#" class="active">
    			        	<span class="time">6 mins</span>
    			        	<img src="assets/demo/avatar/doyle.png" alt="avatar" />
    			        	<div><span class="name">Alan Doyle</span><span class="msg">Please mail me the files by tonight.</span></div>
    			        </a></li>
    			        <li><a href="#">
    			        	<span class="time">12 mins</span>
    			        	<img src="assets/demo/avatar/paton.png" alt="avatar" />
    			        	<div><span class="name">Polly Paton</span><span class="msg">Uploaded all the files to server. Take a look.</span></div>
    			        </a></li>
                    </div>
        			<li class="dd-footer"><a href="Messages.jsp">View All Messages</a></li>
        		</ul>
        	</li-->
            <!--li><a href="#" title="Email"><i class="glyphicon glyphicon-send"></i></a></li-->
        	<!--li class="dropdown">
        		<a href="#" class="hasnotifications dropdown-toggle" data-toggle='dropdown' id="woo"><i class="fa fa-bell"></i><span class="badge">3</span></a>
        		<ul class="dropdown-menu notifications arrow" id="woo2">
        			<li class="dd-header">
        				<span>You have 3 new notification(s)</span>
        				<span><a href="#">Mark all Seen</a></span>
        			</li>
                    <div class="scrollthis">
    				    <li>
    				    	<a href="#" class="notification-user active">
    				    		<span class="time">4 mins</span>
    				    		<i class="fa fa-user"></i>
    				    		<span class="msg">New user Registered. </span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-danger active">
    				    		<span class="time">20 mins</span>
    				    		<i class="fa fa-bolt"></i>
    				    		<span class="msg">CPU at 92% on server#3! </span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-success active">
    				    		<span class="time">1 hr</span>
    				    		<i class="fa fa-check"></i> 
    				    		<span class="msg">Server#1 is live. </span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-warning">
    				    		<span class="time">2 hrs</span>
    				    		<i class="fa fa-exclamation-triangle"></i> 
    				    		<span class="msg">Database overloaded. </span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-order">
    				    		<span class="time">10 hrs</span>
    				    		<i class="fa fa-shopping-cart"></i> 
    				    		<span class="msg">New order received. </span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-failure">
    				    		<span class="time">12 hrs</span>
    				    		<i class="fa fa-times-circle"></i>
    				    		<span class="msg">Application error!</span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-fix">
    				    		<span class="time">12 hrs</span>
    				    		<i class="fa fa-wrench"></i>
    				    		<span class="msg">Installation Succeeded.</span>
    				    	</a>
    				    </li>
    				    <li>
    				    	<a href="#" class="notification-success">
    				    		<span class="time">18 hrs</span>
    				    		<i class="fa fa-check"></i>
    				    		<span class="msg">Account Created. </span>
    				    	</a>
    				    </li>
                    </div>
        			<li class="dd-footer"><a href="#">View All Notifications</a></li>
				</ul>
			</li-->
            <!--li> Header Dropdown
                <a href="#" id="headerbardropdown"><span><i class="fa fa-level-down"></i></span></a>
            </li-->
            <li class="dropdown demodrop">
                <a href="#" class="dropdown-toggle tooltips" data-toggle="dropdown"><i class="fa fa-cogs"></i></a>

                <ul class="dropdown-menu arrow dropdown-menu-form" id="demo-dropdown">
                    <li>
                        <label for="demo-header-variations" class="control-label">Header Colors</label>
                        <ul class="list-inline demo-color-variation" id="demo-header-variations">
                            <li><a class="color-black" href="javascript:;"  data-headertheme="header-black.css"></a></li>
                            <li><a class="color-dark" href="javascript:;"  data-headertheme="default.css"></a></li>
                            <li><a class="color-red" href="javascript:;" data-headertheme="header-red.css"></a></li>
                            <li><a class="color-blue" href="javascript:;" data-headertheme="header-blue.css"></a></li>
                        </ul>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <label for="demo-color-variations" class="control-label">Sidebar Colors</label>
                        <ul class="list-inline demo-color-variation" id="demo-color-variations">
                            <li><a class="color-lite" href="javascript:;"  data-theme="default.css"></a></li>
                            <li><a class="color-steel" href="javascript:;" data-theme="sidebar-steel.css"></a></li>
                            <li><a class="color-lavender" href="javascript:;" data-theme="sidebar-lavender.css"></a></li>
                            <li><a class="color-green" href="javascript:;" data-theme="sidebar-green.css"></a></li>
                        </ul>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <label for="fixedheader">Fixed Header</label>
                        <div id="fixedheader" style="margin-top:5px;"></div> 
                    </li>
                </ul>
            </li>
		</ul>
    </header>