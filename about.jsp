<%--
    Document   : about
    Created on : Oct 30, 2023, 10:29:52 PM
    Author     : KUFRE
--%>

<%--
    Document   : about
    Created on : Oct 30, 2023, 10:20:29 PM
    Author     : KUFRE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>UG WIS - Hotel and Suites</title>
        <jsp:include page="/WEB-INF/fragments/head-fragment.jsp"/>
    </head>

    <body class="about-page">
        <jsp:include page="/WEB-INF/fragments/spinner-top-bar.jsp"/>

        <div class="container-fluid position-relative p-0">
            <jsp:include page="/WEB-INF/fragments/nav-bar.jsp"/>
            <jsp:include page="/WEB-INF/fragments/hero.jsp"/>
        </div>

        <div class="container-xxl py-5">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px; visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                        <div class="position-relative h-100">
                            <img class="img-fluid position-absolute w-100 h-100" src="/images/flags.jpg" alt="" style="object-fit: cover;">
                        </div>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                        <h6 class="section-title bg-white text-start text-primary pe-3">About Us</h6>
                        <h1 class="mb-4">Welcome to <span class="text-primary">UGWIS Hotels and Suites</span></h1>
                        <p class="mb-4 about-text">We are a rare gem in the centre of Calabar with an inviting ambience and quality-oriented service. </p>
                        <p class="mb-4 about-text">UG WIS HOTEL is one of the outstanding hotels in Calabar as it has carved a niche for itself with its wide range offers of elegant accommodation, recreation &amp; Conference facilities with its guests' comfort as a priority. </p>
                        <p class="mb-4 about-text">We are committed to giving you a memorable experience with our friendly staff, smart service, cozy ambience in a Secured Environment. Whether you are lodging, having a conference or just enjoying recreation, we have world class environment for you. We also have assorted beverages at our Pool bar, Smoking bar, a sparkling Club and classy Lounge where you can hangout as well as a Gymnasium to help you keep fit. UGWIS HOTELS &amp; SUITES is strategically located within the heart of Calabar: 10 Minutes’ drive from the Calabar International Airport and about 5minutes to Calabar Stadium. Visit us today at No. 34 New Obutung Street, off MCC Road, Calabar, Cross River State for your: </p>
                        <div class="row gy-2 gx-4 mb-4">
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Tastefully Furnished Rooms</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Ultra-Modern Conference Halls</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Standard Swimming Pool</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>24hrs Power Supply</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Proactive Security Network</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>High Speed Internet Access</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Local Delicacies and International Cuisines</p>
                            </div>
                        </div>
                        <div class="about-book-now">
                            <a href="rooms.jsp" class="btn btn-primary">Book Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            <jsp:include page="/WEB-INF/fragments/scripts.jsp"/>
    </body>
</html>
