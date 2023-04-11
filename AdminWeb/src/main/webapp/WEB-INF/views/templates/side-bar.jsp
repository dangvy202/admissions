<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
          <img src="${pageContext.servletContext.contextPath}/img/Angry-Nerds-2.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
          <span class="brand-text font-weight-light">&nbsp;</span>
        </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="${pageContext.servletContext.contextPath}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">${user.username}</a>
            </div>
        </div>

        <!-- SidebarSearch Form -->
        <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li id="dashboard" class="nav-item">
                    <a id="linkdashboard" href="${pageContext.servletContext.contextPath}/admin" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Dashboard
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a id="home" href="${pageContext.servletContext.contextPath}/admin" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Home</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Categories
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/categories/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Categories List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/categories/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Categories</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Actor
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/actor/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Actor List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/actor/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Actor</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Comment
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/comment/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Comment List</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Storage
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/storage/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Video List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/storage/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Video</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Products
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/product/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Product List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/product/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Product</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Contact
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/contact/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Contact List</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager User
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/user/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>User List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/user/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New User</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Film
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/film/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Film List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/film/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Film</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Crawl
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/crawl/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Crawl List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="newproduct" href="${pageContext.servletContext.contextPath}/admin/crawl/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Crawl</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Coin Web
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/coin/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Coin List</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/coin/new" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>New Coin Account</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li id="managerproduct" class="nav-item">
                    <a id="linkproduct" href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Manager Order
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                    	 <li class="nav-item">
                            <a id="productlist" href="${pageContext.servletContext.contextPath}/admin/order/list" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>Order List</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>