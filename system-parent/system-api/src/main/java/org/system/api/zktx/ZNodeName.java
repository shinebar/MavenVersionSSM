package org.system.api.zktx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZNodeName implements Comparable<ZNodeName> {
    private final String name;
    private String prefix;
    private int sequence = -1;
    private static final Log LOG = LogFactory.getLog(ZNodeName.class);
 
    public ZNodeName(String name) {
        if (name == null) {
            throw new NullPointerException("id cannot be null");
        }
        this.name = name;
        this.prefix = name;
        int idx = name.lastIndexOf('-');
        if (idx >= 0) {
            this.prefix = name.substring(0, idx);
            try {
                this.sequence = Integer.parseInt(name.substring(idx + 1));
                // If an exception occurred we misdetected a sequence suffix,
                // so return -1.
            } catch (NumberFormatException e) {
                LOG.info("Number format exception for " + idx, e);
            } catch (ArrayIndexOutOfBoundsException e) {
                LOG.info("Array out of bounds for " + idx, e);
            }
        }
    }
 
    @Override
    public String toString() {
        return name.toString();
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
 
        ZNodeName sequence = (ZNodeName) o;
 
        if (!name.equals(sequence.name))
            return false;
 
        return true;
    }
 
    @Override
    public int hashCode() {
        return name.hashCode() + 37;
    }
 
    public int compareTo(ZNodeName that) {
        int s1 = this.sequence;
        int s2 = that.sequence;
        if (s1 == -1 && s2 == -1) {
            return this.name.compareTo(that.name);
        }
        if (s1 == -1) {
            return -1;
        } else if (s2 == -1) {
            return 1;
        } else {
            return s1 - s2;
        }
    }
 
    /**
     * Returns the name of the znode
     */
    public String getName() {
        return name;
    }
 
    /**
     * Returns the sequence number
     */
    public int getZNodeName() {
        return sequence;
    }
 
    /**
     * Returns the text prefix before the sequence number
     */
    public String getPrefix() {
        return prefix;
    }
}
