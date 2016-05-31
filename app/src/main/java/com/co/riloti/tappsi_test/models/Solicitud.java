package com.co.riloti.tappsi_test.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Solicitud {

    private int status;
    private int updatetime;
    private String bookingId;
    private String approxAddress;
    private String address;
    private String neighborhood;
    private String code;
    private String lat;
    private String lon;
    private int nightExtra;
    private int chargeStatus;
    private String chargeMessage;
    private List<Object> messages = new ArrayList<Object>();
    private List<Object> broadcastMessages = new ArrayList<Object>();
    private List<Booking> bookings = new ArrayList<Booking>();

    /**
     *
     * @return
     * The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The updatetime
     */
    public int getUpdatetime() {
        return updatetime;
    }

    /**
     *
     * @param updatetime
     * The updatetime
     */
    public void setUpdatetime(int updatetime) {
        this.updatetime = updatetime;
    }

    /**
     *
     * @return
     * The bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     *
     * @param bookingId
     * The booking_id
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     *
     * @return
     * The approxAddress
     */
    public String getApproxAddress() {
        return approxAddress;
    }

    /**
     *
     * @param approxAddress
     * The approx_address
     */
    public void setApproxAddress(String approxAddress) {
        this.approxAddress = approxAddress;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     *
     * @param neighborhood
     * The neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lon
     */
    public String getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     * The nightExtra
     */
    public int getNightExtra() {
        return nightExtra;
    }

    /**
     *
     * @param nightExtra
     * The night_extra
     */
    public void setNightExtra(int nightExtra) {
        this.nightExtra = nightExtra;
    }

    /**
     *
     * @return
     * The chargeStatus
     */
    public int getChargeStatus() {
        return chargeStatus;
    }

    /**
     *
     * @param chargeStatus
     * The charge_status
     */
    public void setChargeStatus(int chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    /**
     *
     * @return
     * The chargeMessage
     */
    public String getChargeMessage() {
        return chargeMessage;
    }

    /**
     *
     * @param chargeMessage
     * The charge_message
     */
    public void setChargeMessage(String chargeMessage) {
        this.chargeMessage = chargeMessage;
    }

    /**
     *
     * @return
     * The messages
     */
    public List<Object> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     * The messages
     */
    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    /**
     *
     * @return
     * The broadcastMessages
     */
    public List<Object> getBroadcastMessages() {
        return broadcastMessages;
    }

    /**
     *
     * @param broadcastMessages
     * The broadcast_messages
     */
    public void setBroadcastMessages(List<Object> broadcastMessages) {
        this.broadcastMessages = broadcastMessages;
    }

    /**
     *
     * @return
     * The bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     *
     * @param bookings
     * The bookings
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String toString (){
        String bookings = "";
        for (Booking b :this.getBookings()){
            bookings = bookings + "["+b.toString()+"] ";
        }
        String str = "Solicitud= updatetime:"+getUpdatetime()+" status:"+getStatus()+" bookings:"+getBookings().size()+" {"+bookings+"}";
        return str;
    }

}