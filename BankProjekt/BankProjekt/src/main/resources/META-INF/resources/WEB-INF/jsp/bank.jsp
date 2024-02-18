<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<body>
    <div class="container">
        <header>
            <h1>Welcome to Our Bank</h1>
            <p>Your Account is now open!</p>
        </header>

        <section class="features">
            <h2>Explore and Manage</h2>
            
            <div class="feature-buttons">
                <a href="list-programmers" class="btn btn-primary">Manage Programmers</a>
                <a href="list-economists" class="btn btn-primary">Manage Economists</a>
                <a href="list-customers" class="btn btn-primary">Manage Customers</a>
            </div>
        </section>

        <!-- Include Bootstrap and jQuery if needed -->
        <!--
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        -->
    </div>

<%@ include file="common/footer.jsp" %>
