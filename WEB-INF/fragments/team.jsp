<%--
    Document   : team
    Created on : Oct 28, 2023, 3:34:51 PM
    Author     : Jevison7x
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!-- Team Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-3">Learn More with</h6>
                    <h1 class="mb-5">Our Video Gallery</h1>
                </div>
                <div class="row g-4">
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="team-item">
                            <div class="overflow-hidden video-cont">
                                <video width="320" height="240" controls poster="/images/glance.JPG">
                                    <source src="/videos/glance.mp4" type="video/mp4">
                                </video>
                            </div>

                            <div class="text-center p-4">
                                <h5 class="mb-0">At A Glance</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                        <div class="team-item">
                            <div class="overflow-hidden video-cont">
                               <video width="320" height="240" poster="/images/blade5.JPG" controls>
                                   <source src="/videos/interior.mp4" type="video/mp4">
                                </video>
                            </div>
                            <div class="text-center p-4">
                                <h5 class="mb-0">Our Interior</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                        <div class="team-item">
                            <div class="overflow-hidden video-cont">
                                <video width="320" height="240" controls poster="/images/echo1.JPG">
                                    <source src="/videos/echo.mp4" type="video/mp4">
                                </video>
                            </div>
                            <div class="text-center p-4">
                                <h5 class="mb-0">Echo Lounge</h5>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Team End -->