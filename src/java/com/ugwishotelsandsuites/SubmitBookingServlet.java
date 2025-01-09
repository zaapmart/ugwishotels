/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.ugwishotelsandsuites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author KUFRE
 * @since Nov 14, 2023 6:24:27 PM
 */
public class SubmitBookingServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsono = new JSONObject();
        try
        {
            String clientName = request.getParameter("clientName");
            String clientPhoneNumber = request.getParameter("clientPhoneNumber");
            String clientEmail = request.getParameter("clientEmail");
            String clientGender = request.getParameter("clientGender");
            String adults = request.getParameter("adults");
            String children = request.getParameter("children");
            String checkinStart = request.getParameter("checkinStart");
            String duration = request.getParameter("duration");
            String roomType = request.getParameter("roomType");
            String quantity = request.getParameter("room_count");
            String total_amount = request.getParameter("quantity");
            Booking booking = new Booking();
            booking.setRoom_id(roomType);
            booking.setName(clientName);
            booking.setEmail(clientEmail);
            booking.setGender(clientGender);
            booking.setDate_in(checkinStart);
            booking.setAdult_count(adults);
            booking.setChildren_count(children);
            booking.setMobile_number(clientPhoneNumber);
            booking.setRoom_count(quantity);
            double total_cost = Double.parseDouble(total_amount);
            booking.setTotal_amount(total_cost);
            Room room = RoomsDAO.getRoombyId(Integer.parseInt(booking.getRoom_id()));
            String[] checkinArray = checkinStart.split("-");
            int year = Integer.parseInt(checkinArray[0]);
            int month = Integer.parseInt(checkinArray[1]);
            int day = Integer.parseInt(checkinArray[2]);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, day);
            int durationInt = Integer.parseInt(duration);
            cal.add(Calendar.DATE, durationInt);
            booking.setDate_out(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
            booking.setCreated_at(DateTimeUtil.getTodayTimeZone());
            BookingDAO.insertBooking(booking);
            String message = htmlMessage(booking, room);
            String subject = "New Booking Alert";
            String sendersEmail = "booking@ugwishotelsandsuites.com";
            String adminEmail = "amanameren2015@gmail.com";
            sendHtmlMail(adminEmail, sendersEmail, subject, message);
            jsono.put("status", "success");
            out.print(jsono);
        }
        catch(Exception xcp)
        {
            try
            {
                jsono.put("status", "error");
                jsono.put("message", xcp.getMessage());
                out.print(jsono);
            }
            catch(JSONException jsone)
            {
                xcp.printStackTrace(System.err);
            }
        }
        finally
        {
            out.close();
        }
    }

    private void sendHtmlMail(String email, String sendersEmail, String subject, String newMessage)
    {
        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        try
        {
            // Create a default MimeMessage object.
            MimeMessage mimeMessage = new MimeMessage(session);
            // Set From: header field of the header.
            mimeMessage.setFrom(new InternetAddress(sendersEmail));
            // Set To: header field of the header.
            mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));
            // Set Subject: header field
            mimeMessage.setSubject(subject);
            // Now set the actual message
            mimeMessage.setContent(newMessage, "text/html");
            // Send message
            Transport.send(mimeMessage);
        }
        catch(MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }

    private String htmlMessage(Booking booking, Room room)
    {
        StringBuilder message = new StringBuilder();
        message.append("<div>");
        message.append("<div>");
        message.append("<h2>New Booking Request</h2>");
        message.append("</div>");
        message.append("<div>");
        message.append("<p style=\"font-weight: bold;\">Customer Name: <span>").append(booking.getName()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Gender: <span>").append(booking.getGender()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Phone Number: <span>").append(booking.getMobile_number()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Email: <span>").append(booking.getEmail()).append("</span></p>");
        message.append("<p style=\"font-weight: bold\">Adults: <span>").append(booking.getAdult_count()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Children: <span>").append(booking.getChildren_count()).append("</span></p>");
        message.append("<p style=\"font-weight: bold\">Room Type: <span>").append(room.getType()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Checkin Date: <span>").append(booking.getDate_in()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Checkout Date: <span>").append(booking.getDate_out()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Number of Rooms: <span>").append(booking.getRoom_count()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Room Cost: <span>").append(room.getCost()).append("</span></p>");
        message.append("<p style=\"font-weight: bold;\">Total Amount: <span>").append(booking.getTotal_amount()).append("</span></p>");
        message.append("</div>");
        message.append("<div>");
        message.append("<p>Kindly call customer for payment and complete booking request</p");
        message.append("</div>");
        message.append("</div>");
        return message.toString();
    }
}
