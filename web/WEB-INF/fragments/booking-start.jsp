<%--
    Document   : booking-start
    Created on : Oct 28, 2023, 3:36:15 PM
    Author     : jevis
--%>

<%@page import="com.ugwishotelsandsuites.RoomsDAO"%>
<%@page import="com.ugwishotelsandsuites.Room"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="room" class="com.ugwishotelsandsuites.Room"/>
<%
    List<Room> rooms = RoomsDAO.getAllRooms();
    request.setAttribute("rooms", rooms);
%>
<!-- Booking Start -->
<section id="booking-section">
    <div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="container">
            <div class="booking p-5 booking2">
                <div class="row g-5 align-items-center">
                    <div class="col-md-6 text-white">
                        <h6 class="text-white text-uppercase">Online Booking</h6>
                        <h1 class="text-white mb-4">Make A Reservation</h1>
                        <p class="mb-4">Our booking system is a 2-step process designed with you in mind. All you have to do is "Fill in your personal information and click to book</p>
                        <p class="mb-4">Kindly note that reservations are based on available spaces. You can call our customer service on +2348167849880 to confirm availability.</p>

                    </div>
                    <div class="col-md-6">
                        <h1 class="text-white mb-4">Book Here</h1>
                        <form id="booking-form">
                            <div class="row">
                                <div class="col-md-12" style="margin-top: 23px;">
                                    <input type="text" class="form-control" id="client-name" placeholder="Enter Name" name="clientName" required>
                                </div>
                                <div class="col-md-6" style="margin-top: 23px;">
                                    <input type="number" class="form-control" id="phoneNumber" placeholder="Enter Phone Number" name="clientPhoneNumber" required>
                                </div>
                                <div class="col-md-6" style="margin-top: 23px;">
                                    <input type="email" class="form-control" id="clientEmail" placeholder="Enter Email" name="clientEmail" required>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" aria-label="Default select example" name="clientGender" required>
                                        <option selected>Select you Gender</option>
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" aria-label="Default select example" name="adults" required>
                                        <option selected>Select Adults</option>
                                        <option value="1">1 adults</option>
                                        <option value="2">2 adults</option>
                                        <option value="3">3 adults</option>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" name="children" required>
                                        <option selected>Select Children</option>
                                        <option value="0">0 Child</option>
                                        <option value="1">1 Child</option>
                                        <option value="2">2 Children</option>
                                        <option value="3">3 Children</option>
                                    </select>
                                </div>
                                <div class="col-md-3 kuf-top" style="padding-top: 7px;">
                                    Check-in Date:
                                </div>
                                <div class="col-md-3 kuf-top" style="padding-left: 0px;">
                                    <input type="date" id="start"
                                           name="checkinStart" value=""
                                           min="2023-01-23"
                                           class="w-100 date-in"
                                           required/>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" name="roomType" id="room-select" required>
                                        <option selected>Select Room Type</option>
                                        <c:forEach var="room" items="${rooms}">
                                            <option value="${room.id}">${room.type}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <script>
                                    var rooms = {};
                                <c:forEach var="room" items="${rooms}">
                                    rooms[${room.id}] = '${room.cost}';
                                </c:forEach>
                                </script>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" name="duration" id="duration" required>
                                        <option value="0" selected>Duration</option>
                                        <c:forEach var="i" begin="1" end="365" step="1">
                                        <option value="${i}">${i} Nights</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-select kuf-top" name="quantity" id="quantity" required>
                                        <option value="0" selected>Number of Rooms</option>
                                        <c:forEach var="q" begin="1" end="20" step="1">
                                        <option value="${q}">${q} Rooms</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6" style="margin-top: 23px;">
                                    <label class="form-control" id="room-cost" style="height: 38px;"></label>
                                </div>
                                <div class="col-md-12 input-group mb-4" style="margin-top: 18px;">
                                    <span class="input-group-text">Total Cost: </span>
                                    <label class="form-control" id="booking-total" style="height: 38px;"></label>
                                    <input type="hidden" name="total_amount" id="total-amount"/>
                                </div>
                                <div class="col-12" style="margin-top: 23px;">
                                    <button type="submit" class="btn btn-primary btn-lg w-100" id="submit-booking" name="bookBtn">
                                        <span class="material-symbols-outlined send-icon">
                                            send
                                        </span>Book Now
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Booking Start -->
