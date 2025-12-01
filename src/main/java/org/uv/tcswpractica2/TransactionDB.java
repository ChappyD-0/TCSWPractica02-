
package org.uv.tcswpractica2;

import java.sql.Connection;


public abstract class TransactionDB<T, ID> {
    
    protected T pojoDB;
    protected TransactionDB(T pojoDB){
        this.pojoDB = pojoDB;
    }
    public abstract boolean execute ( Connection con);

}
