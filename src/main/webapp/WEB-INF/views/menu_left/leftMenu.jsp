<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="javascript:void(0);">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Gestion de Stock</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<c:url value="/home/" var="home"/>
	<li class="nav-item"><a class="nav-link" href="${home }"> 
	<i class="fas fa-fw fa-tachometer-alt"></i> <span>  <fmt:message key="common.dashbord" /> </span></a></li>
	<hr class="sidebar-divider">
	<c:url value="/article/" var="article"/>
	<li class="nav-item"><a class="nav-link" href="${article }">
	 <i class="fas fa-fw fa-tachometer-alt"></i> <span>  <fmt:message key="common.article" /> </span></a></li>		

	<!-- Divider -->
	<hr class="sidebar-divider">

	


	<!-- Nav Item - Pages client Menu -->
	
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseOne" aria-expanded="true"
		aria-controls="collapseOne"> <i class="fas fa-fw fa-cog"></i> <span><fmt:message key="common.client" /></span>
	</a>
		<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Components:</h6>
				<c:url value="/client/" var="client"/>
				<a class="collapse-item" href="${client}"><fmt:message key="common.client" /></a>
				<c:url value="/commandeclient/" var="cdeClient"/>
				 <a class="collapse-item" href="${cdeClient}"><fmt:message key="common.client.commande" /></a>
			</div>
		</div></li>
		<hr class="sidebar-divider">
     <li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" 
		aria-expanded="true" aria-controls="collapseTwo"> 
		 <i class="fas fa-fw fa-cog"></i> <span><fmt:message key="common.fournisseur" /></span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Components:</h6>
				<c:url value="/fournisseur/" var="fournisseur"/>
				<a class="collapse-item" href="${fournisseur}"><fmt:message key="common.fournisseur" /></a> <a
				<c:url value="/commandefournisseur/" var="cdeFournisseur"/>
					class="collapse-item" href="${cdeFournisseur}"><fmt:message key="common.fournisseur.commande" /></a>
			</div>
		</div></li>
		<hr class="sidebar-divider">
		<!-- Nav Item - stock -->
		<c:url value="/stock/" var="stock"/>
	<li class="nav-item"><a class="nav-link" href="${stock}">
	 <i class="fas fa-fw fa-table"></i> <span><fmt:message key="common.stock" /></span></a></li>
		<!-- Nav Item - vente -->
		
		<hr class="sidebar-divider">
		<c:url value="/vente/" var="vente"/>
	<li class="nav-item"><a class="nav-link" href="${vente}"> <i
			class="fas fa-fw fa-chart-area"></i> <span><fmt:message key="common.vente" /></span></a></li>

	
		
	<!-- Nav Item - Utilities Collapse Menu -->
	<hr class="sidebar-divider">
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span><fmt:message key="common.parametrage" /></span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom parametrage:</h6>
				<c:url value="/utilisateur/" var="utilisateur"/>
				<a class="collapse-item" href="${utilisateur}"><fmt:message key="common.parametrage.utilisateur" /></a> 
				<c:url value="/category/" var="category"/>
				<a class="collapse-item" href="${category}"><fmt:message key="common.parametrage.cateegory" /></a> 
				
			</div>
   </div></li>


</ul>