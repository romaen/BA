
/* First created by JCasGen Thu Sep 08 19:44:05 CEST 2016 */
package org.pr.ba.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Sep 14 23:26:06 CEST 2016
 * @generated */
public class Other_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Other.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.pr.ba.type.Other");



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Other_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    