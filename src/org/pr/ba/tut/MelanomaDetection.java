package org.pr.ba.tut;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.pr.ba.type.Document;
import org.pr.ba.type.Melanom;
import org.pr.ba.type.Nevus;
import org.pr.ba.type.Other;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class MelanomaDetection extends JCasAnnotator_ImplBase {

	private DocumentCategorizerME categorizer;

	public void initialize(UimaContext ctx) throws ResourceInitializationException {
		super.initialize(ctx);

		InputStream dmis = null;

		try {
			dmis = getContext().getResourceAsStream("DoccatModel");
			DoccatModel dmodel = new DoccatModel(dmis);
			categorizer = new DocumentCategorizerME(dmodel);
			dmis.close();
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// String inputText = jcas.getDocumentText();

		FSIndex docAnnIndex = jcas.getAnnotationIndex(Document.type);
		Iterator docAnnIterator = docAnnIndex.iterator();

		while (docAnnIterator.hasNext()) {
			Document docAnn = (Document) docAnnIterator.next();
			String docTxt = docAnn.getCoveredText();

			int docAnnStart = docAnn.getBegin();
			int docAnnEnd = docAnn.getEnd();

			double[] outcome = categorizer.categorize(docTxt);

			System.out.println(outcome[0] + ", " + outcome[1]);
			if (outcome[0] >= 0.65) {
				Melanom melanomAnnotation = new Melanom(jcas);
				melanomAnnotation.setBegin(docAnnStart);
				melanomAnnotation.setEnd(docAnnEnd);
				melanomAnnotation.addToIndexes(jcas);
			} else if (outcome[1] >= 0.65) {
				Nevus nevusAnnotation = new Nevus(jcas);
				nevusAnnotation.setBegin(docAnnStart);
				nevusAnnotation.setEnd(docAnnEnd);
				nevusAnnotation.addToIndexes(jcas);
			} else {
				Other otherAnnotation = new Other(jcas);
				otherAnnotation.setBegin(docAnnStart);
				otherAnnotation.setEnd(docAnnEnd);
				otherAnnotation.addToIndexes(jcas);
			}
		}
	}

}
