private int hash(Object key) {
            // Compute a hash code for the key; key cannot be null.
            // The hash code depends on the size of the table as
            // well as on the value returned by key.hashCode().
         return (Math.abs(key.hashCode())) % table.length;
      }
