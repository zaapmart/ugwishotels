<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>UG WIS - Hotel and Suites</title>
        <jsp:include page="/WEB-INF/fragments/head-fragment.jsp"/>
    </head>
    <body class="tour-page">
        <jsp:include page="/WEB-INF/fragments/spinner-top-bar.jsp"/>

        <div class="container-fluid position-relative p-0">
            <jsp:include page="/WEB-INF/fragments/nav-bar.jsp"/>
            <jsp:include page="/WEB-INF/fragments/hero.jsp"/>
        </div>
        <div class="container-xxl py-5 destination">
            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-3">Places you may want to visit:</h6>
                    <h1 class="mb-5">Popular Destinations</h1>
                </div>
                <div class="row g-3">
                    <div class="col-lg-7 col-md-6">
                        <div class="row g-3">
                            <div class="col-lg-12 col-md-12 wow zoomIn" data-wow-delay="0.1s">
                                <a class="position-relative d-block overflow-hidden" href="">
                                    <img class="img-fluid" src="/images/tinapa2.jpg" alt="">
                                    <div class="bg-white text-danger fw-bold position-absolute top-0 start-0 m-3 py-1 px-2">For Business and Leisure</div>
                                    <div class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2">Tinapa </div>
                                </a>
                            </div>
                            <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.3s">
                                <a class="position-relative d-block overflow-hidden" href="">
                                    <img class="img-fluid" src="/images/agbokim.jpg" alt="">
                                    <div class="bg-white text-danger fw-bold position-absolute top-0 start-0 m-3 py-1 px-2">Experience</div>
                                    <div class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2">Agbokim Waterfalls</div>
                                </a>
                            </div>
                            <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.5s">
                                <a class="position-relative d-block overflow-hidden" href="">
                                    <img class="img-fluid" src="/images/marina1.jpg" alt="">
                                    <div class="bg-white text-danger fw-bold position-absolute top-0 start-0 m-3 py-1 px-2">Experience</div>
                                    <div class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2">Marina Resort</div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5 col-md-6 wow zoomIn" data-wow-delay="0.7s" style="min-height: 350px;">
                        <a class="position-relative d-block h-100 overflow-hidden" href="">
                            <img class="img-fluid position-absolute w-100 h-100" src="/images/obudu.jpg" alt="" style="object-fit: cover;">
                            <div class="bg-white text-danger fw-bold position-absolute top-0 start-0 m-3 py-1 px-2">Visit</div>
                            <div class="bg-white text-primary fw-bold position-absolute bottom-0 end-0 m-3 py-1 px-2">Obudu Cattle Ranch</div>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
            <jsp:include page="/WEB-INF/fragments/scripts.jsp"/>
    </body>
</html>