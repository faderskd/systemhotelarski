/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObslugaLogowania;

/**
 *
 * @author monum_000
 */
public class XDaneLogowania {
        
   private String Login;
   private String Password;

    @Override
    public String toString() {
        return "XDaneLogowania{" + "Login=" + Login + ", Password=" + Password + '}';
    }

   public XDaneLogowania(String log, String passwd){
       this.Login = log;
       this.Password = passwd;
   }
   
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
