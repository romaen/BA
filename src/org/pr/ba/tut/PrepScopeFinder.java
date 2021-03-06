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
import org.pr.ba.type.PrepScope;
import org.pr.ba.type.Token;

import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.namefind.DictionaryNameFinder;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;

public class PrepScopeFinder extends JCasAnnotator_ImplBase {
	private TokenizerME tokenizer;

	public void initialize(UimaContext ctx) throws ResourceInitializationException {
		super.initialize(ctx);
		InputStream tmis = null;

		try {
			tmis = getContext().getResourceAsStream("TokenizerModel");
			TokenizerModel tmodel = new TokenizerModel(tmis);
			tokenizer = new TokenizerME(tmodel);
			tmis.close();
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		String inputTxt = jcas.getDocumentText();
		FSIndex tokenAnnIndex = jcas.getAnnotationIndex(Token.type);
		FSIndex docAnnIndex = jcas.getAnnotationIndex(Document.type);
		Iterator tokenAnnIterator = tokenAnnIndex.iterator();
		Iterator docAnnIterator = docAnnIndex.iterator();

		Dictionary prepDict1 = new Dictionary();
		Dictionary prepDict2 = new Dictionary();
		prepDict2.put(new StringList("Das", "Präparat"));
//		prepDict1.put(new StringList("Präparate"));
		prepDict2.put(new StringList("OP-Präparat"));
		prepDict2.put(new StringList("Exzisionspräparat"));

		prepDict1.put(new StringList("Präp", "."));
		prepDict1.put(new StringList("Präparat", "1]"));
		prepDict1.put(new StringList("Präparat", "2]"));
		prepDict1.put(new StringList("Präparat", "3]"));
		prepDict1.put(new StringList("Präparat", "4]"));
		prepDict1.put(new StringList("Präparat", "5]"));
		prepDict1.put(new StringList("Präparat", "1", ")"));
		prepDict1.put(new StringList("Präparat", "2", ")"));
		prepDict1.put(new StringList("Präparat", "3", ")"));
		prepDict1.put(new StringList("Präparat", "4", ")"));
		prepDict1.put(new StringList("Präparat", "5", ")"));

		DictionaryNameFinder dictNameFinder = new DictionaryNameFinder(prepDict1, "PrepScope");
		// String[] tokensTxt = tokenizer.tokenize(inputTxt);
		String[] docTxt = tokenizer.tokenize(inputTxt);
		Span[] tokenSpans = tokenizer.tokenizePos(inputTxt);

//		while (docAnnIterator.hasNext()) {};
//			Document docAnn = (Document) docAnnIterator.next();
//			String[] documentTxt = tokenizer.tokenize(docAnn.getCoveredText());
//			int docStart = docAnn.getBegin();
//			int docEnd = docAnn.getEnd();
			Span[] span = dictNameFinder.find(docTxt);

//			if (span.length == 0) {
//				prepAnn.setBegin(docStart);
//				prepAnn.setEnd(docEnd);
//				prepAnn.addToIndexes(jcas);
//			}
			
//			String[] docTxt = tokenizer.tokenize(docAnn.getCoveredText());

			for (int i = 0; i < span.length; i++) {
				PrepScope prepAnn = new PrepScope(jcas);
				int prepStart = span[i].getStart();
				int prepEnd = span[i].getEnd();
				int tokenStart = tokenSpans[prepStart].getStart();
				int tokenEnd = tokenSpans[prepEnd].getStart();
				prepAnn.setBegin(tokenStart);
				prepAnn.setEnd(tokenEnd);
				prepAnn.addToIndexes(jcas);
			}
			// for (int i = 0; i < span.length; i++) {
			// int prepStart = span[i].getStart();
			// int prepEnd = span[i].getEnd();
			// int tokenStart = tokenSpans[prepStart].getStart();
			// int tokenEnd = tokenSpans[prepEnd].getStart();
			// System.out.println(tokenSpans[prepStart].equals("Präp."));
			// if (tokenSpans[prepStart].equals("Präp.")) {
			// prepAnn.setBegin(docStart);
			// prepAnn.setEnd(docEnd);
			// prepAnn.addToIndexes(jcas);
			// } else if (tokenSpans[prepStart].equals("Präparat")) {
			// prepAnn.setBegin(docStart);
			// prepAnn.setEnd(docEnd);
			// prepAnn.addToIndexes(jcas);
			// }

			// int prepStart = span[i].getStart();
			// int prepEnd = span[i].getEnd();
			// int tokenStart = tokenSpans[prepStart].getStart();
			// int tokenEnd = tokenSpans[prepEnd].getStart();
			// prepAnn.setBegin(docStart);
			// prepAnn.setEnd(docEnd);
			// prepAnn.addToIndexes(jcas);
		

		// while (docAnnIterator.hasNext()) {}; Document docAnn = (Document)


	}

}
