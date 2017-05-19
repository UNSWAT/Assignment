/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suber.Models;

/**
 *
 * @author sunyifei
 */
public class MembershipPayment {
    
    private String status;
    private String lastMatch;
    private String nextExpiry;
    private int durationToExpiry;
    private int refundFlag;

    public MembershipPayment(String status, String lastMatch, String nextExpiry, 
            int durationToExpiry, int refundFlag) {
        this.status = status;
        this.lastMatch = lastMatch;
        this.nextExpiry = nextExpiry;
        this.durationToExpiry = durationToExpiry;
        this.refundFlag = refundFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastMatch() {
        return lastMatch;
    }

    public void setLastMatch(String lastMatch) {
        this.lastMatch = lastMatch;
    }

    public String getNextExpiry() {
        return nextExpiry;
    }

    public void setNextExpiry(String nextExpiry) {
        this.nextExpiry = nextExpiry;
    }

    public int getDurationToExpiry() {
        return durationToExpiry;
    }

    public void setDurationToExpiry(int durationToExpiry) {
        this.durationToExpiry = durationToExpiry;
    }

    public int getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(int refundFlag) {
        this.refundFlag = refundFlag;
    }
    
}
