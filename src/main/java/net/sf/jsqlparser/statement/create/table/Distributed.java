/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2021 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.create.table;

import java.util.List;

public class Distributed {
    private DistributionMode mode;
    private List<String> columns;

    public Distributed(DistributionMode mode){
        this.mode = mode;
    }
    public Distributed(List<String> columns) {
        this.mode = DistributionMode.COLUMNS;
        this.columns = columns;
    }

    public DistributionMode getMode() {
        return mode;
    }

    public void setMode(DistributionMode mode) {
        this.mode = mode;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        if (mode == DistributionMode.COLUMNS) {
            StringBuilder sb = new StringBuilder();
            sb.append("DISTRIBUTED BY (");
            boolean comma = false;
            for (String column : columns) {
                if (comma) {
                    sb.append(", ");
                } else {
                    comma = true;
                }
                sb.append(column);
            }
            sb.append(")");
            return sb.toString();
        } else {
            return "DISTRIBUTED " + mode.name();
        }
    }
}
