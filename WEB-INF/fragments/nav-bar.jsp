<%--
    Document   : nav-bar
    Created on : Oct 28, 2023, 2:57:48 PM
    Author     : Jevison7x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-lg-0">
    <a href="index.jsp" class="navbar-brand p-0">
        <div>
            <img src="/images/ugwishotellogo.png" alt="Logo">

        </div>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="fa fa-bars"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto py-0">
            <a href="index.jsp" class="nav-item nav-link home-link">Home</a>
            <a href="about.jsp" class="nav-item nav-link about-link">About</a>
            <a href="facilities.jsp" class="nav-item nav-link facilities-link">Facilities</a>
            <div class="nav-item dropdown">
                <a href="rooms.jsp" class="nav-item nav-link room-link">Rooms</a>
                <div class="dropdown-menu m-0">
                    <a href="rooms.jsp#splendid-room-section" class="dropdown-item">Splendid Room</a>
                    <a href="rooms.jsp#deluxe-room-section" class="dropdown-item">Deluxe Room</a>
                    <a href="rooms.jsp#executive-suite-section" class="dropdown-item">Executive Room</a>
                    <a href="rooms.jsp#luxury-section" class="dropdown-item">Luxury Room</a>
                    <a href="rooms.jsp#classic-section" class="dropdown-item">Classic Room</a>
                    <a href="rooms.jsp#royal-section" class="dropdown-item">Royal Apartment</a>
                </div>
            </div>
            <a href="tour-sites.jsp" class="nav-item nav-link tour-link">Tour Sites</a>
            <a href="contact.jsp" class="nav-item nav-link contact-link">Contact</a>
        </div>
    </div>
</nav>
