

/* First created by JCasGen Mon Sep 12 17:18:54 CEST 2016 */
package org.pr.ba.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Sep 20 17:53:15 CEST 2016
 * XML source: C:/Users/Julien/workspace/UIMA_Pipeline/desc/PrepScopeDescr.xml
 * @generated */
public class PrepScope extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PrepScope.class);
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
  protected PrepScope() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public PrepScope(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public PrepScope(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public PrepScope(JCas jcas, int begin, int end) {
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
  //* Feature: PrepInDoc

  /** getter for PrepInDoc - gets 
   * @generated
   * @return value of the feature 
   */
  public int getPrepInDoc() {
    if (PrepScope_Type.featOkTst && ((PrepScope_Type)jcasType).casFeat_PrepInDoc == null)
      jcasType.jcas.throwFeatMissing("PrepInDoc", "org.pr.ba.type.PrepScope");
    return jcasType.ll_cas.ll_getIntValue(addr, ((PrepScope_Type)jcasType).casFeatCode_PrepInDoc);}
    
  /** setter for PrepInDoc - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPrepInDoc(int v) {
    if (PrepScope_Type.featOkTst && ((PrepScope_Type)jcasType).casFeat_PrepInDoc == null)
      jcasType.jcas.throwFeatMissing("PrepInDoc", "org.pr.ba.type.PrepScope");
    jcasType.ll_cas.ll_setIntValue(addr, ((PrepScope_Type)jcasType).casFeatCode_PrepInDoc, v);}    
  }

    