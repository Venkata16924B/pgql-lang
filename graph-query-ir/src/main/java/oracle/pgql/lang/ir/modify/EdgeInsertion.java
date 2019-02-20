/*
 * Copyright (C) 2013 - 2019 Oracle and/or its affiliates. All rights reserved.
 */
package oracle.pgql.lang.ir.modify;

import java.util.List;
import java.util.Set;

import oracle.pgql.lang.ir.QueryEdge;
import oracle.pgql.lang.ir.QueryExpressionVisitor;

public class EdgeInsertion extends AbstractInsertion {

  private QueryEdge edge;

  public EdgeInsertion(QueryEdge edge, Set<String> labels, List<SetPropertyExpression> properties) {
    super(labels, properties);
    this.edge = edge;
  }

  public QueryEdge getEdge() {
    return edge;
  }

  public void setEdge(QueryEdge edge) {
    this.edge = edge;
  }

  @Override
  public ModificationType getModificationType() {
    return ModificationType.INSERT_EDGE;
  }

  @Override
  public String toString() {
    return "INSERT EDGE " + edge.getName() + " FROM " + edge.getSrc().getName() + " TO " + edge.getDst().getName()
        + printLabels() + printProperties();
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj))
      return false;
    EdgeInsertion other = (EdgeInsertion) obj;
    if (edge == null) {
      if (other.edge != null)
        return false;
    } else if (!edge.equals(other.edge))
      return false;
    return true;
  }

  @Override
  public void accept(QueryExpressionVisitor v) {
    v.visit(this);
  }

}
