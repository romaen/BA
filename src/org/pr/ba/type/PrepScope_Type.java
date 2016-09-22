
/* First created by JCasGen Mon Sep 12 17:18:54 CEST 2016 */
package org.pr.ba.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Sep 20 17:53:15 CEST 2016
 * @generated */
public class PrepScope_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PrepScope.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.pr.ba.type.PrepScope");



  /** @generated */
  final Feature casFeat_PrepInDoc;
  /** @generated */
  final int     casFeatCode_PrepInDoc;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPrepInDoc(int addr) {
        if (featOkTst && casFeat_PrepInDoc == null)
      jcas.throwFeatMissing("PrepInDoc", "org.pr.ba.type.PrepScope");
    return ll_cas.ll_getIntValue(addr, casFeatCode_PrepInDoc);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPrepInDoc(int addr, int v) {
        if (featOkTst && casFeat_PrepInDoc == null)
      jcas.throwFeatMissing("PrepInDoc", "org.pr.ba.type.PrepScope");
    ll_cas.ll_setIntValue(addr, casFeatCode_PrepInDoc, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public PrepScope_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_PrepInDoc = jcas.getRequiredFeatureDE(casType, "PrepInDoc", "uima.cas.Integer", featOkTst);
    casFeatCode_PrepInDoc  = (null == casFeat_PrepInDoc) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_PrepInDoc).getCode();

  }
}



    