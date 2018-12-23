/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author thanh
 */
public class MdWorkday {
    
    public int      id;
    public int      user_id;
    public int      workday;
    public int      monthday;
    public int      hours;
    
    public MdWorkday() {
        id              = 0;
        user_id         = 0;
        workday         = 0;
        monthday        = 0;
        hours           = 0;
    }
    
    public MdWorkday(
        int     id,
        int     user_id,
        int     workday,
        int     monthday,
        int     hours
    )
    {
        this.id         =  id;
        this.user_id    =  user_id;
        this.workday    =  workday;
        this.monthday   =  monthday;
        this.hours      =  hours;
     
    }
}
