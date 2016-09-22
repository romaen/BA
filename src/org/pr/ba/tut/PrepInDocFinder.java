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

import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.namefind.DictionaryNameFinder;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringList;

public class PrepInDocFinder extends JCasAnnotator_ImplBase {
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
		FSIndex docAnnIndex = jcas.getAnnotationIndex(Document.type);
		Iterator docAnnIterator = docAnnIndex.iterator();

		Dictionary prepDict1 = new Dictionary();
		Dictionary prepDict2 = new Dictionary();
		prepDict2.put(new StringList("Das", "Präparat"));
		prepDict2.put(new StringList("OP-Präparat"));
		prepDict2.put(new StringList("Exzisionspräparat"));
		prepDict2.put(new StringList("Excisionspräparat"));

		prepDict1.put(new StringList("+"));
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
		DictionaryNameFinder dictNameFinder2 = new DictionaryNameFinder(prepDict2, "PrepScope");

		while (docAnnIterator.hasNext()) {
			Document docAnn = (Document) docAnnIterator.next();
			String[] documentTxt = tokenizer.tokenize(docAnn.getCoveredText());
			int docStart = docAnn.getBegin();
			int docEnd = docAnn.getEnd();
			Span[] span = dictNameFinder.find(documentTxt);
			Span[] span2 = dictNameFinder2.find(documentTxt);

			if (span.length == 0) {
				if (span2.length == 0) {
					PrepScope prepAnn = new PrepScope(jcas);
					prepAnn.setPrepInDoc(1);
					prepAnn.setBegin(docStart);
					prepAnn.setEnd(docEnd);
					prepAnn.addToIndexes(jcas);
				} else {

					PrepScope prepAnn = new PrepScope(jcas);
					prepAnn.setPrepInDoc(span2.length);
					prepAnn.setBegin(docStart);
					prepAnn.setEnd(docEnd);
					prepAnn.addToIndexes(jcas);

				}
			} else if (span.length > 0) {

				PrepScope prepAnn = new PrepScope(jcas);
				prepAnn.setPrepInDoc(span.length);
				prepAnn.setBegin(docStart);
				prepAnn.setEnd(docEnd);
				prepAnn.addToIndexes(jcas);

			} else {
				PrepScope prepAnn = new PrepScope(jcas);
				prepAnn.setPrepInDoc(1);
				prepAnn.setBegin(docStart);
				prepAnn.setEnd(docEnd);
				prepAnn.addToIndexes(jcas);
			}
		}

	}

}
