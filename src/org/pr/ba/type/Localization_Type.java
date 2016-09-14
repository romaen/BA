
/* First created by JCasGen Tue Sep 13 16:16:52 CEST 2016 */
package org.pr.ba.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Sep 13 16:18:52 CEST 2016
 * @generated */
public class Localization_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Localization.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.pr.ba.type.Localization");
 
  /** @generated */
  final Feature casFeat_acral;
  /** @generated */
  final int     casFeatCode_acral;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAcral(int addr) {
        if (featOkTst && casFeat_acral == null)
      jcas.throwFeatMissing("acral", "org.pr.ba.type.Localization");
    return ll_cas.ll_getStringValue(addr, casFeatCode_acral);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAcral(int addr, String v) {
        if (featOkTst && casFeat_acral == null)
      jcas.throwFeatMissing("acral", "org.pr.ba.type.Localization");
    ll_cas.ll_setStringValue(addr, casFeatCode_acral, v);}
    
  
 
  /** @generated */
  final Feature casFeat_arm;
  /** @generated */
  final int     casFeatCode_arm;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getArm(int addr) {
        if (featOkTst && casFeat_arm == null)
      jcas.throwFeatMissing("arm", "org.pr.ba.type.Localization");
    return ll_cas.ll_getStringValue(addr, casFeatCode_arm);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArm(int addr, String v) {
        if (featOkTst && casFeat_arm == null)
      jcas.throwFeatMissing("arm", "org.pr.ba.type.Localization");
    ll_cas.ll_setStringValue(addr, casFeatCode_arm, v);}
    
  
 
  /** @generated */
  final Feature casFeat_hnf;
  /** @generated */
  final int     casFeatCode_hnf;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getHnf(int addr) {
        if (featOkTst && casFeat_hnf == null)
      jcas.throwFeatMissing("hnf", "org.pr.ba.type.Localization");
    return ll_cas.ll_getStringValue(addr, casFeatCode_hnf);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setHnf(int addr, String v) {
        if (featOkTst && casFeat_hnf == null)
      jcas.throwFeatMissing("hnf", "org.pr.ba.type.Localization");
    ll_cas.ll_setStringValue(addr, casFeatCode_hnf, v);}
    
  
 
  /** @generated */
  final Feature casFeat_leg;
  /** @generated */
  final int     casFeatCode_leg;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLeg(int addr) {
        if (featOkTst && casFeat_leg == null)
      jcas.throwFeatMissing("leg", "org.pr.ba.type.Localization");
    return ll_cas.ll_getStringValue(addr, casFeatCode_leg);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLeg(int addr, String v) {
        if (featOkTst && casFeat_leg == null)
      jcas.throwFeatMissing("leg", "org.pr.ba.type.Localization");
    ll_cas.ll_setStringValue(addr, casFeatCode_leg, v);}
    
  
 
  /** @generated */
  final Feature casFeat_trunk;
  /** @generated */
  final int     casFeatCode_trunk;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTrunk(int addr) {
        if (featOkTst && casFeat_trunk == null)
      jcas.throwFeatMissing("trunk", "org.pr.ba.type.Localization");
    return ll_cas.ll_getStringValue(addr, casFeatCode_trunk);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTrunk(int addr, String v) {
        if (featOkTst && casFeat_trunk == null)
      jcas.throwFeatMissing("trunk", "org.pr.ba.type.Localization");
    ll_cas.ll_setStringValue(addr, casFeatCode_trunk, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Localization_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_acral = jcas.getRequiredFeatureDE(casType, "acral", "uima.cas.String", featOkTst);
    casFeatCode_acral  = (null == casFeat_acral) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_acral).getCode();

 
    casFeat_arm = jcas.getRequiredFeatureDE(casType, "arm", "uima.cas.String", featOkTst);
    casFeatCode_arm  = (null == casFeat_arm) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_arm).getCode();

 
    casFeat_hnf = jcas.getRequiredFeatureDE(casType, "hnf", "uima.cas.String", featOkTst);
    casFeatCode_hnf  = (null == casFeat_hnf) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hnf).getCode();

 
    casFeat_leg = jcas.getRequiredFeatureDE(casType, "leg", "uima.cas.String", featOkTst);
    casFeatCode_leg  = (null == casFeat_leg) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_leg).getCode();

 
    casFeat_trunk = jcas.getRequiredFeatureDE(casType, "trunk", "uima.cas.String", featOkTst);
    casFeatCode_trunk  = (null == casFeat_trunk) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_trunk).getCode();

  }
}



    