package org.pr.ba.tut;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.pr.ba.type.Document;
import org.pr.ba.type.Melanom;
import org.pr.ba.type.Nevus;
import org.pr.ba.type.Other;


public class DocAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		FSIndex docAnnIndex = jcas.getAnnotationIndex(Document.type);
		
		Iterator docAnnIterator = docAnnIndex.iterator();
		
		while(docAnnIterator.hasNext()) {
			Document docAnn = (Document) docAnnIterator.next();
			String docTxt = docAnn.getCoveredText();
			
			
			docAnn.getBegin();
			docAnn.getEnd();
			
		}


	}

}
