package com.ebartmedia.practiceexercise.controller;

import com.ebartmedia.practiceexercise.model.EngWord;
import com.ebartmedia.practiceexercise.model.EngWordNumber;
import com.ebartmedia.practiceexercise.model.EngwordSupport;
import com.ebartmedia.practiceexercise.model.RandPl;
import com.ebartmedia.practiceexercise.model.Word;
import com.ebartmedia.practiceexercise.model.Wordnumber;
import com.ebartmedia.practiceexercise.model.Words;
import com.ebartmedia.practiceexercise.service.EngWordNumberService;
import com.ebartmedia.practiceexercise.service.EngwordService;
import com.ebartmedia.practiceexercise.service.RandPlService;
import com.ebartmedia.practiceexercise.service.WordnumberService;
//import com.ebartmedia.practiceexercise.service.WordsService;
import com.ebartmedia.practiceexercise.service.WordsService;
import com.ebartmedia.practiceexercise.service.WordssService;
import com.ebartmedia.practiceexercise.repository.WordsRepository;
import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")

@CrossOrigin(origins = {"http://localhost:4200"})

@RestController
@RequestMapping("/api")
public class WordController {
	
	List<Word> word = new ArrayList<Word>();
	List<Wordnumber> wordNumber = new ArrayList<Wordnumber>();
	List<EngWordNumber> engWordNumber = new ArrayList<EngWordNumber>();
	List<EngWordNumber> engwordnumberService = new ArrayList<EngWordNumber>();
	
	@Autowired
	private WordsService wordsService;
	
	@Autowired
	private RandPlService randPlService;
	
	@Autowired
	private WordsRepository wordsRepository;
	
//	@Autowired
//	private RandPlService RandPlService;
	
	@Autowired
	private EngwordService engwordService;
	
	@Autowired
	private WordnumberService wordnumberService;
	
	@Autowired
	private WordssService wordssService;
	
	
	@Autowired
	private EngWordNumberService engWordNumberService;
	
	
	@RequestMapping(value = "/words, method = RequestMethod.GET")
	public String showWord() {
		
		String label = "lkjasd";
		
		return label;
	}

	
	@RequestMapping(value = "/word", method = RequestMethod.GET)
	public List<Word> getWords() {

		Word word = new Word();
		
		List<Word> wordList = new ArrayList<Word>();
		
		String plword = "";
		int idplword = 1;
		int countrandom = 1;
		int randplword = 1;	
		
		this.countRandom();
		
		randplword = randPlService.findRandPlWord();  
		  
		
		System.out.println("word - randplword" + randplword);
		
		wordnumberService.updWordNumber(randplword);
		
	//	wordnumberService.updWordnumber(randplword);
		
		System.out.println("word" + randplword);
		
	//	this.getIdPlWord(randplword);
		
		plword = wordsService.getWord(randplword);
		
	    word.setPlword(plword);
	  //  word.setIdplword(idplword);
	    
	    wordList.add(new Word(plword));
	    
	  //  wordList.add(new Word(idplword));
		
		
	//	System.out.println(countrandom);
		
        return wordList;
		
		
		
//		List<Word> word = new ArrayList<Word>();
//		
//		word.add(new Word("kind","rodzaj"));
//		
//		
//		for (int i=0; i<word.size(); i++) {
//			
//			System.out.println(word.get(0));
//		}
//		
//		return word;
		
//		this.countRandom();
//		
//		randplword = randPlService.findRandPlWord();  
//		  
//		plword = wordsService.getWord(randplword);
//		
//		System.out.println(countrandom);
//		
//		return plword;
	}
	
	
	@RequestMapping(value = "/idplword", method = RequestMethod.GET)
	public List<Wordnumber> getIdPlWord() {
		
		
		String plword = "";
		
		int idplword = 1;
		
		int randplword = 1;
		
		
		Wordnumber wordnumber = new Wordnumber();
	
		List<Wordnumber> wordNumber = new ArrayList<Wordnumber>();
	
		
        this.countRandom();
		
		randplword = randPlService.findRandPlWord();
		
		
		plword = wordsService.getWord(randplword);
		
		
		idplword = wordsService.getWordIdNumber(plword);
		
		
	//	wordnumber.setWordnumber(randplword);
		wordnumber.setWordnumber(idplword);
		
		wordNumber.add(new Wordnumber(idplword));
		
		
		return wordNumber;
		
	}
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)

	@ResponseBody
	public String create(@RequestBody Words words) {
		
		 String wordid = "";
		
		try {
			
			wordsService.save(words);
			
			wordid = String.valueOf(words.getId());
			
		} catch(Exception ex) {
			
			return "Error while inserting the word:" + ex.toString();
		}
		
		return "Word successfully inserted with id = " + wordid;
		
		
	}
	
	
	@RequestMapping(value = "/showcount", method = RequestMethod.GET)
	public int showCount() {
		
		
		int showcount = wordsService.showCount();
		
		return showcount;
	}
	
	@RequestMapping(value = "/countrandom", method = RequestMethod.GET)
	public int countRandom() {
		
		RandPl randPl = new RandPl();
		
		
		int countrandom = 1;
		int randplword = 1;
		
		String plword = "";
		
		try {
			
			int countrows = this.showCount();
			int min = 1;
			int max = countrows;
			
			Random random = new Random();
			
			countrandom = random.nextInt(max - min + 1) + min;
			
			randPlService.updIdAndRandPl(countrandom);
			
//			randPl.setRandPlWord(countrandom);
//			
//			randPlService.save(randPl);
			

			
//			wordsRepository.getWord(n1);

			System.out.println(countrandom);
			
		//	wordsRepository.findWord(n1);
			
 			plword = wordsRepository.getWord(countrandom);
			
 			System.out.println(plword);
 		//	System.out.println("Rand Pl" + getRandPl());
 			
 	//		this.getWord(countrandom);
 	//		this.getWord(plword);
 			
		//	n1 = wordService.getWord(n1);
			
			return countrandom;
			
		} catch( Exception e) {
			
			e.toString();
		}
		
		return countrandom;
	}
	
	
	
//	@RequestMapping(value = "/posteng",  consumes = { "text/xml", "application/xml" }, method = RequestMethod.POST)
	@RequestMapping(value = "/posteng", method = RequestMethod.POST)
	@ResponseBody
//	public String getEngWord(@PathVariable("typedengword") String typedengword) {
//	public String getEngWord(@PathVariable(value = "typedengword") String typedengword) {
	public String getEngWord(@RequestBody EngWord engWord) { 
//	public String getEngWord(@RequestParam(value = "typedengword") String typedengword) {	
		String label = "lkajsdf";
		
	//	String typedendword = formParams.getBytes("typedengword");
		
	//	System.out.println(typedengword);
		
//		model.addAttribute("typedengword", new EngWord());
		
//		System.out.println(model.addAttribute("typedengword", new EngWord()));
		
	    String engword = "";
		
		System.out.println("engword" + engword);
		
	    String typedengword = "";
	    
	    int wordnumber = 1;
		
	    int getwordnumber = 1;
	   // Float getwordnumber;
	    
		engword = engWord.getTypedEngword();
		
		System.out.println("gettypedengword" + engWord.getTypedEngword());
		
	//	System.out.println("getallwords" + wordssService.getAllWords());
		
//	    System.out.println("getllwords" + this.getAllWords());
		
	//	System.out.println("word existrs" + wordssService.wordExists(typedengword));
	//	System.out.println("word existrs" + wordsService.wordExists(typedengword));
	    
	    System.out.println("getengwordnumber" + wordsService.getEngWordNumber(engword));
		
	    System.out.println("the-engwordnumber" + this.getEngWordNumber(engword));
	    
	  //  getwordnumber = wordsService.getEngWordNumber(engword);
	    
//	    if (getwordnumber != 0) 
//	    	
//	    	return "OK";
//	    	
//	    else 
//	    	
//	    	return "NO";
//	    
	    
	    
	    
	    System.out.println("Word number" + wordsService.getWordNumber(engword));
//	    System.out.println("getengwordnumber" + wordsService.getEngWordNumber(typedengword));
	  //  System.out.println("getengwordnumber" + this.getEngWordNumber(engword));
	    
	    
		 String wordid = "";
			
			try {
				
			//	engwordService.save(engWord);
				
				engwordService.updEngWord(engword);
				typedengword = engwordService.findTypedEngword();
			//	this.getWordNumber(typedengword, getwordnumber);
				
//				System.out.println("Word number" + wordsService.getWordNumber(typedengword));
				
//				System.out.println("getengwordnumber" + wordsService.getEngWordNumber(typedengword));
				
//				getwordnumber = wordsService.getWordNumber(typedengword);
				
			//	System.out.println("word existrs" + wordssService.wordExists(typedengword));
			//	System.out.println("getallwords" + wordssService.getAllWords());
			
			//	this.getWordNumber(typedengword, getwordnumber);
				this.getWordsNumber();
				
		//		System.out.println("Rand Pl" + getRandPl());
				
			//	System.out.println(compareGetRandPlAndGetWordNumber(getwordnumber));
				
//				System.out.println("compareGetRandPlAndGetWordNumber" + compareGetRandPlAndGetWordNumber(engword));
				
			//	wordid = String.valueOf(engWord.getEngwordId());
				
			} catch(Exception ex) {
				
				return "Error while inserting the word:" + ex.toString();
			}
			
		//	return "Word successfully inserted with id = " + wordid;
			
			
		
			
		
		
		return engword;
		
//	return typedengword;
		
	//	return label;
		
	}
	
	
	@RequestMapping(value = "/getwordsnumber", method = RequestMethod.GET)
//	@ResponseBody
//	public int getWordsNumber() {
	public List<Wordnumber> getWordsNumber() {	

	//	String engword = "kind";
//
		String engword = "";
		
		String typedengword = "";
		
		int wordnumber = 1;
	//	Float wordnumber;
		
//		return wordsService.getWordNumber(engword);
		
		Wordnumber wordNumber = new Wordnumber();
		
		List<Wordnumber> wNumber = new ArrayList<Wordnumber>();
		
		engword = engwordService.findTypedEngword();
		
		
		System.out.println("word number" +  wordsService.getWordNumber(engword));

		System.out.println("typedengword" + engwordService.findTypedEngword());
		
		
		
		wordnumber = wordsService.getWordNumber(engword);
		
	//	wordnumberService.updWordnumber(wordnumber); // this was
		
		wordnumberService.updWordNumber(wordnumber);
		
		//	System.out.println("word number" + wordnumber);
		
		wordNumber.setWordnumber(wordnumber);
		
	//	engWord.add(new WordNumber(wordnumber));
		
//		engWord.add(new WordNumber(wordnumber));

		wNumber.add(new Wordnumber(wordnumber));
		
//		return engWord;
		return wNumber;
		
		
		
	}
	
	
	@RequestMapping(value = "/getrandplword", method = RequestMethod.GET)
	public List<RandPl> getRandPlWord() {
		
		int randplword = 1;
		
		RandPl randpl = new RandPl();
		
		List<RandPl> randPl = new ArrayList<RandPl>();
		
		System.out.println("getrandplword" + randPlService.findRandPlWord());
		
		randplword = randPlService.findRandPlWord();
	
		
		System.out.println("getrandplword" + randplword);
		
		randpl.setRandPlWord(randplword);
//		
//		
		randPl.add(new RandPl(randplword));
//		
		return randPl;
		
	}
	
	
	
	
	@RequestMapping(value = "/getword", method = RequestMethod.GET)
//	@ResponseBody
	public String getWord() {
		
	String plword = "";	
	int countrandom = 1;
	int randplword = 1;	
//	 Words words = new Words();
//	 
//	int n1 = 1; 
//		
//		String label = "lkjasd";
//		String getword = "";
		
//	      countrandom = this.countRandom();  //here
//		  plword = wordsService.getWord(countrandom); //here
		
	    this.countRandom();
	
		randplword = randPlService.findRandPlWord();  
		  
		plword = wordsService.getWord(randplword);
		
		System.out.println(countrandom);
		
		return plword;
		
	//	return plword;
		
	//	String getword = wordService.getWord();
		
	//	getword = wordsService.getWord(n1);
		
		
		
	//	getword = wordsService.findWord(n1);

	//	getword = wordsRepository.findWord(n1);
		
	//	System.out.println(wordsRepository.findWord(n1));
		
	//	return getword;
		
	//	return label;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/getrandpl", method = RequestMethod.GET)
	@ResponseBody
	public int getRandPl() {
		
		return randPlService.findRandPlWord();
	}
	
	
	@RequestMapping(value = "/getwordnumber", method = RequestMethod.GET)
	@ResponseBody
//	public int getWordNumber(String typedengword, int getwordnumber) {
	public float getWordNumber(String typedengword, int getwordnumber) {	
//	public boolean getWordNumber(String typedengword, int getwordnumber) {	
		int x = 1;
		
	//	System.out.println("get word number" + wordsService.getWordNumber(typedengword));
		
	 //   int getwordnumber = 1;
		
	//    this.compareGetRandPlAndGetWordNumber(getwordnumber);
	    
	    
		return wordsService.getWordNumber(typedengword);
		
		
		
	//	System.out.println("get word number" + x);
		
	//	return x;
	}
	
	
	public ResponseEntity<List<Words>> getAllWords() {
		
		List<Words> list = wordssService.getAllWords();
		
		return new ResponseEntity<List<Words>>(list, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getengwordnumber", method = RequestMethod.GET)
	@ResponseBody
//	public String getEngWordNumber(String engword) {
	public List<EngWordNumber> getEngWordNumber(String engword) {	
		
		
	//	String engword = "";
		
		String engwordOk = "";
		String engwordNo = "";
		
		EngWordNumber engwordNumber = new EngWordNumber();
	    List<EngWordNumber> engWordNumber = new ArrayList<EngWordNumber>();
		
		
		String word = "lasdf";
		
		int getengwordnumb;
		String geteng;
		
	//	float getengwordnumber;
	    Integer getengwordnumber;
		
	    
//	    engwordNumber.setEngWordNumberOk("OK");
//	    engwordNumber.setEngWordNumberNo("NO");
//	    
//	    engwordOk = engwordNumber.getEngWordNumberOk();
//	    engwordNo = engwordNumber.getEngWordNumberOk();
//	    
//	    engWordNumber.add(new EngWordNumber(engwordOk, engwordNo));
//	    
	//	getengwordnumber = wordsService.getEngWordNumber(engword);
		
		getengwordnumber = wordsService.getEngWordNumber(engword);
		
		
		
		engwordNumber.setEngWordNumber(getengwordnumber);
		
	//	engWordNumberService.save(engwordNumber);
		engWordNumberService.updEngWordNumber(getengwordnumber);

		engWordNumber.add(new EngWordNumber(getengwordnumber));
		
//		if (getengwordnumber == 2) {
//			
//			return "OK";
//		} else {
//			return "NO";
//		}
		
		
//		geteng = Float.toString(getengwordnumber);
//	
//		System.out.println("getEngWordNumber - getengwordnumb" + geteng);
//		
		
		
	//	System.out.println("getEngWordNumber - getengwordnumber" + wordsService.getEngWordNumber(engword));
		
	//	return word;
		
	//	return getengwordnumber;
		
		
		return engWordNumber;
		
//		if (getengwordnumber != 0) {
//			
//			return "YES";
//		} else {
//			
//			return "YES";
//		}
//		
	
		
		
	}
	
	
	
	@RequestMapping(value = "/gettengwordnumber", method = RequestMethod.GET)
	@ResponseBody
//	public String getEngWordNumber(String engword) {
	public List<EngWordNumber> gettEngWordNumber(String engword) {	
		
		
	//	String engword = "";
		
		String engwordOk = "";
		String engwordNo = "";
		
		EngWordNumber engwordNumber = new EngWordNumber();
	    List<EngWordNumber> engwordnumberService = new ArrayList<EngWordNumber>();
		
		
		String word = "lasdf";
		
		int getengwordnumb;
		String geteng;
		
	//	float getengwordnumber;
	    Integer getengwordnumber;
		
	    
//	    engwordNumber.setEngWordNumberOk("OK");
//	    engwordNumber.setEngWordNumberNo("NO");
//	    
//	    engwordOk = engwordNumber.getEngWordNumberOk();
//	    engwordNo = engwordNumber.getEngWordNumberOk();
//	    
//	    engWordNumber.add(new EngWordNumber(engwordOk, engwordNo));
//	    
	//	getengwordnumber = wordsService.getEngWordNumber(engword);
		
	//	getengwordnumber = wordsService.getEngWordNumber(engword);
		getengwordnumber = engWordNumberService.findEngWordNumber();
		
		
		
		engwordNumber.setEngWordNumber(getengwordnumber);
		
	//	engWordNumberService.save(engwordNumber);
	//	engWordNumberService.updEngWordNumber(getengwordnumber);

		engwordnumberService.add(new EngWordNumber(getengwordnumber));
		
//		if (getengwordnumber == 2) {
//			
//			return "OK";
//		} else {
//			return "NO";
//		}
		
		
//		geteng = Float.toString(getengwordnumber);
//	
//		System.out.println("getEngWordNumber - getengwordnumb" + geteng);
//		
		
		
	//	System.out.println("getEngWordNumber - getengwordnumber" + wordsService.getEngWordNumber(engword));
		
	//	return word;
		
	//	return getengwordnumber;
		
		return engwordnumberService;
		
	//	return engWordNumber;
		
		
//		if (getengwordnumber != 0) {
//			
//			return "YES";
//		} else {
//			
//			return "YES";
//		}
//		
	
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value = "/getrandengwordnumber", method = RequestMethod.GET)
	@ResponseBody
//	public String getEngWordNumber(String engword) {
//	public String getRandEngWordNumber(String engword) {
//	public List<EngWordNumber> getRandEngWordNumber(String engword) {	
	public List<EngwordSupport> getRandEngWordNumber(String engword) {	
		
	//	String engword = "";
		
		String engwordOk = "";
		String engwordNo = "";
		
	//	EngWordNumber engwordNumber = new EngWordNumber();
	//	Wordnumber wordnumber = new Wordnumber();
		
		EngwordSupport engwordsupport = new EngwordSupport();
		
	//    List<EngWordNumber> engwordnumberService = new ArrayList<EngWordNumber>();
		List<EngwordSupport> wordnumb = new ArrayList<EngwordSupport>();
		
		String word = "lasdf";
		
		int getengwordnumb;
		String geteng;
		
	//	float getengwordnumber;
	    Integer getengwordnumber;
	    int randengwordnumber;
	    String randengword;
		
	    
//	    engwordNumber.setEngWordNumberOk("OK");
//	    engwordNumber.setEngWordNumberNo("NO");
//	    
//	    engwordOk = engwordNumber.getEngWordNumberOk();
//	    engwordNo = engwordNumber.getEngWordNumberOk();
//	    
//	    engWordNumber.add(new EngWordNumber(engwordOk, engwordNo));
//	    
	//	getengwordnumber = wordsService.getEngWordNumber(engword);
		
	//	getengwordnumber = wordsService.getEngWordNumber(engword);
		getengwordnumber = engWordNumberService.findEngWordNumber();
		
		randengwordnumber = wordnumberService.findRandEngWordNumber();
		
		randengword = wordsService.getRandEngWord(randengwordnumber);
		
        engwordsupport.setEngwordSupport(randengword);
		
	//	engwordNumber.setEngWordNumber(getengwordnumber);

//		wordnumber.setWordnumber(randengword);
		
	//	engWordNumberService.save(engwordNumber);
	//	engWordNumberService.updEngWordNumber(getengwordnumber);

	//	engwordnumberService.add(new EngwordSupport(getengwordnumber));

      //  wordnumb.add(new EngwordSupport(engwordsupport));
        
        wordnumb.add(new EngwordSupport(randengword));
        
	//	wordnumb.add(randengword);
		
		
//		if (getengwordnumber == 2) {
//			
//			return "OK";
//		} else {
//			return "NO";
//		}
		
		
//		geteng = Float.toString(getengwordnumber);
//	
//		System.out.println("getEngWordNumber - getengwordnumb" + geteng);
//		
		
		
	//	System.out.println("getEngWordNumber - getengwordnumber" + wordsService.getEngWordNumber(engword));
		
	//	return word;
		
	//	return getengwordnumber;
		
	//	return engwordnumberService;
	
	//	return randengword;
		
		return wordnumb;
	//	return engWordNumber;
		
		
//		if (getengwordnumber != 0) {
//			
//			return "YES";
//		} else {
//			
//			return "YES";
//		}
//		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/getcompare", method = RequestMethod.GET)
//	@ResponseBody
//	public String getCompare() {
//		
//	    int getwordnumber = 1;
//		
//	    String good = "Good";
//	    String bad = "Bad";
//	    
//	    if (this.compareGetRandPlAndGetWordNumber(getwordnumber)) {
//	    	
//	    	return good;
//	    } else {
//		
//	    	return bad;
//	    }
//	}
	
	
}
