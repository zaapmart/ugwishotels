<%--
    Document   : index
    Created on : Oct 28, 2023, 2:34:17 PM
    Author     : Jevison7x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>UG WIS - Hotel and Suites</title>
        <jsp:include page="/WEB-INF/fragments/head-fragment.jsp"/>
    </head>
    <body class="home-page">
        <jsp:include page="/WEB-INF/fragments/spinner-top-bar.jsp"/>
        <!-- Navbar & Hero Start -->
        <div class="container-fluid position-relative p-0">
            <jsp:include page="/WEB-INF/fragments/nav-bar.jsp"/>
            <jsp:include page="/WEB-INF/fragments/hero.jsp"/>
        </div>
        <!-- Navbar & Hero End -->
        <jsp:include page="/WEB-INF/fragments/about.jsp"/>
        <jsp:include page="/WEB-INF/fragments/service-start.jsp"/>
        <jsp:include page="/WEB-INF/fragments/features.jsp"/>
        <jsp:include page="/WEB-INF/fragments/package-start.jsp"/>
        <jsp:include page="/WEB-INF/fragments/booking-start.jsp"/>
        <jsp:include page="/WEB-INF/fragments/destination-start.jsp"/>
        <jsp:include page="/WEB-INF/fragments/process-start.jsp"/>
        <jsp:include page="/WEB-INF/fragments/team.jsp"/>
        <jsp:include page="/WEB-INF/fragments/testimonial.jsp"/>
        <jsp:include page="/WEB-INF/fragments/buy-now-modal.jsp"/>
        <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
        <jsp:include page="/WEB-INF/fragments/scripts.jsp"/>
    </body>
</html>