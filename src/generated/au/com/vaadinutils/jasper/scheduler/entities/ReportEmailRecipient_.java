/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package au.com.vaadinutils.jasper.scheduler.entities;

import java.lang.Long;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=au.com.vaadinutils.jasper.scheduler.entities.ReportEmailRecipient.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Wed May 14 16:16:28 EST 2014")
public class ReportEmailRecipient_ {
    public static volatile SingularAttribute<ReportEmailRecipient,String> emailAddress;
    public static volatile SingularAttribute<ReportEmailRecipient,Long> iID;
    public static volatile SingularAttribute<ReportEmailRecipient,ReportEmailRecipientVisibility> visibility;
}