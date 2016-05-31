package com.co.riloti.tappsi_test.models;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Booking {

    private String bookingId;
    private String approxAddress;
    private String address;
    private String neighborhood;
    private int code;
    private float lat;
    private float lon;

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
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The lat
     */
    public float getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lon
     */
    public float getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    public String toString(){
        return "code:"+getCode()+" approx_address:"+getApproxAddress()+" lat:"+getLat()+" lon:"+getLon();
    }

}