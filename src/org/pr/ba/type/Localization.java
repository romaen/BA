

/* First created by JCasGen Tue Sep 13 16:16:52 CEST 2016 */
package org.pr.ba.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Sep 13 16:18:52 CEST 2016
 * XML source: C:/Users/Julien/workspace/UIMA_Pipeline/desc/LocationAEDescr.xml
 * @generated */
public class Localization extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Localization.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Localization() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Localization(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Localization(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Localization(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: acral

  /** getter for acral - gets 
   * @generated
   * @return value of the feature 
   */
  public String getAcral() {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_acral == null)
      jcasType.jcas.throwFeatMissing("acral", "org.pr.ba.type.Localization");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Localization_Type)jcasType).casFeatCode_acral);}
    
  /** setter for acral - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAcral(String v) {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_acral == null)
      jcasType.jcas.throwFeatMissing("acral", "org.pr.ba.type.Localization");
    jcasType.ll_cas.ll_setStringValue(addr, ((Localization_Type)jcasType).casFeatCode_acral, v);}    
   
    
  //*--------------*
  //* Feature: arm

  /** getter for arm - gets 
   * @generated
   * @return value of the feature 
   */
  public String getArm() {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_arm == null)
      jcasType.jcas.throwFeatMissing("arm", "org.pr.ba.type.Localization");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Localization_Type)jcasType).casFeatCode_arm);}
    
  /** setter for arm - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setArm(String v) {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_arm == null)
      jcasType.jcas.throwFeatMissing("arm", "org.pr.ba.type.Localization");
    jcasType.ll_cas.ll_setStringValue(addr, ((Localization_Type)jcasType).casFeatCode_arm, v);}    
   
    
  //*--------------*
  //* Feature: hnf

  /** getter for hnf - gets 
   * @generated
   * @return value of the feature 
   */
  public String getHnf() {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_hnf == null)
      jcasType.jcas.throwFeatMissing("hnf", "org.pr.ba.type.Localization");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Localization_Type)jcasType).casFeatCode_hnf);}
    
  /** setter for hnf - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setHnf(String v) {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_hnf == null)
      jcasType.jcas.throwFeatMissing("hnf", "org.pr.ba.type.Localization");
    jcasType.ll_cas.ll_setStringValue(addr, ((Localization_Type)jcasType).casFeatCode_hnf, v);}    
   
    
  //*--------------*
  //* Feature: leg

  /** getter for leg - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLeg() {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_leg == null)
      jcasType.jcas.throwFeatMissing("leg", "org.pr.ba.type.Localization");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Localization_Type)jcasType).casFeatCode_leg);}
    
  /** setter for leg - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLeg(String v) {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_leg == null)
      jcasType.jcas.throwFeatMissing("leg", "org.pr.ba.type.Localization");
    jcasType.ll_cas.ll_setStringValue(addr, ((Localization_Type)jcasType).casFeatCode_leg, v);}    
   
    
  //*--------------*
  //* Feature: trunk

  /** getter for trunk - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTrunk() {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_trunk == null)
      jcasType.jcas.throwFeatMissing("trunk", "org.pr.ba.type.Localization");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Localization_Type)jcasType).casFeatCode_trunk);}
    
  /** setter for trunk - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTrunk(String v) {
    if (Localization_Type.featOkTst && ((Localization_Type)jcasType).casFeat_trunk == null)
      jcasType.jcas.throwFeatMissing("trunk", "org.pr.ba.type.Localization");
    jcasType.ll_cas.ll_setStringValue(addr, ((Localization_Type)jcasType).casFeatCode_trunk, v);}    
  }

    