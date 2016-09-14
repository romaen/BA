package org.pr.ba.tut;

import java.io.InputStream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.pr.ba.type.Melanom;
import org.pr.ba.type.Nevus;
import org.pr.ba.type.Other;
import org.pr.ba.type.Sentence;
import org.pr.ba.type.Token;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

/*
 * TODO: Define Scope for single Mikro entry (<CR>) (Scope I)
 * TODO: Define Scope for Präparat (REGEX) (Scope II)
 * TODO: Define Pipeline ==> Sentence -> Token -> Scope I -> Scope II -> DocCAT 
 * TODO: Define AE for NER of Präparat & Location
 */




public class OpenNLPTokenizer extends JCasAnnotator_ImplBase {

	private SentenceDetectorME sentenceDetector;
	private TokenizerME tokenizer;
	private DocumentCategorizerME categorizer;
	
	public void initialize(UimaContext ctx) throws ResourceInitializationException {
		super.initialize(ctx);
		InputStream smis = null;
		InputStream tmis = null;
		InputStream dmis = null;

		try {
			smis = getContext().getResourceAsStream("SentenceModel");
			SentenceModel smodel = new SentenceModel(smis);
			sentenceDetector = new SentenceDetectorME(smodel);
			smis.close();
			tmis = getContext().getResourceAsStream("TokenizerModel");
			TokenizerModel tmodel = new TokenizerModel(tmis);
			tokenizer = new TokenizerME(tmodel);
			tmis.close();
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
		// TODO Auto-generated method stub
		String inputText = jcas.getDocumentText(); 
		Span[] sentSpans = sentenceDetector.sentPosDetect(inputText);
		Span[] tokenSpans = tokenizer.tokenizePos(inputText);
		for (Span tokenSpan : tokenSpans) {
			int start = tokenSpan.getStart();
			int end = tokenSpan.getEnd();
			Token tokenAnnotation = new Token(jcas);
			tokenAnnotation.setBegin(start);
			tokenAnnotation.setEnd(end);
			tokenAnnotation.addToIndexes(jcas);
		}
		
		for (Span sentSpan : sentSpans) {
//			String sentence = sentSpan.getCoveredText(inputText).toString();
			int start = sentSpan.getStart();
			int end = sentSpan.getEnd();
			Sentence sentenceAnnotation = new Sentence(jcas);
			sentenceAnnotation.setBegin(start);
			sentenceAnnotation.setEnd(end);
			sentenceAnnotation.addToIndexes(jcas);
			
//			Span[] tokenSpan = tokenizer.tokenizePos(sentence);
//			
//			for(Span token: tokenSpan) {
//				tokens = token.getCoveredText(inputText).toString();
//				System.out.println(tokens);
//				int tokStart = token.getStart();
//				int tokEnd = token.getEnd();
//				Token tokenAnnotation = new Token(jcas);
//				tokenAnnotation.setBegin(tokStart);
//				tokenAnnotation.setEnd(tokEnd);
//				tokenAnnotation.addToIndexes(jcas);
//			}
		}
		
		double[] outcome = categorizer.categorize(inputText);
		/*int categoryNum = categorizer.getNumberOfCategories();
		String[] categoryNames = {};
		
		for(int i = 0; i < categoryNum; i++) {
			categoryNames[i] = categorizer.getCategory(i);
		}*/
				
		System.out.println(outcome[0] + ", " + outcome[1]);
		if(outcome[0] >= 0.65) {
			Melanom melanomAnnotation = new Melanom(jcas);
			melanomAnnotation.setBegin(0);
			melanomAnnotation.setEnd(inputText.length());
			melanomAnnotation.addToIndexes(jcas);
		} else if (outcome[1] >= 0.65) {
			Nevus nevusAnnotation = new Nevus(jcas);
			nevusAnnotation.setBegin(0);
			nevusAnnotation.setEnd(inputText.length());
			nevusAnnotation.addToIndexes(jcas);
		} else {
			Other otherAnnotation = new Other(jcas);
			otherAnnotation.setBegin(0);
			otherAnnotation.setEnd(inputText.length());
			otherAnnotation.addToIndexes(jcas);
		}
	}

}
