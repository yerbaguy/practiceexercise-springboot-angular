package com.ebartmedia.practiceexercise.controller;

import com.ebartmedia.practiceexercise.model.EngWord;
import com.ebartmedia.practiceexercise.model.RandPl;
import com.ebartmedia.practiceexercise.model.Word;
import com.ebartmedia.practiceexercise.model.Words;
import com.ebartmedia.practiceexercise.service.EngwordService;
import com.ebartmedia.practiceexercise.service.RandPlService;
//import com.ebartmedia.practiceexercise.service.WordsService;
import com.ebartmedia.practiceexercise.service.WordsService;
import com.ebartmedia.practiceexercise.repository.WordsRepository;
import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WordController {
	
	List<Word> word = new ArrayList<Word>();
	
	@Autowired
	private WordsService wordsService;
	
	@Autowired
	private RandPlService randPlService;
	
	@Autowired
	private WordsRepository wordsRepository;
	
	@Autowired
	private RandPlService RandPlService;
	
	@Autowired
	private EngwordService engwordService;
	
	
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
		int countrandom = 1;
		int randplword = 1;	
		
		this.countRandom();
		
		randplword = randPlService.findRandPlWord();  
		  
		plword = wordsService.getWord(randplword);
		
	    word.setPlword(plword);
	    
	    wordList.add(new Word(plword));
		
		
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
	    String typedengword = "";
	    
	    int wordnumber = 1;
		
	    int getwordnumber = 1;
	    
		engword = engWord.getTypedEngword();
		
		
		 String wordid = "";
			
			try {
				
			//	engwordService.save(engWord);
				
				engwordService.updEngWord(engword);
				typedengword = engwordService.findTypedEngword();
			//	this.getWordNumber(typedengword, getwordnumber);
				
				System.out.println("Word number" + wordsService.getWordNumber(typedengword));
				
				getwordnumber = wordsService.getWordNumber(typedengword);
			
				this.getWordNumber(typedengword, getwordnumber);
				
				System.out.println("Rand Pl" + getRandPl());
				
				System.out.println(compareGetRandPlAndGetWordNumber(getwordnumber));
				
				
			//	wordid = String.valueOf(engWord.getEngwordId());
				
			} catch(Exception ex) {
				
				return "Error while inserting the word:" + ex.toString();
			}
			
		//	return "Word successfully inserted with id = " + wordid;
			
			
		
		
		
		
		return engword;
		
//	return typedengword;
		
	//	return label;
		
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
	public int getWordNumber(String typedengword, int getwordnumber) {
		
		int x = 1;
		
	//	System.out.println("get word number" + wordsService.getWordNumber(typedengword));
		
	 //   int getwordnumber = 1;
		
	    this.compareGetRandPlAndGetWordNumber(getwordnumber);
	    
	    
		return wordsService.getWordNumber(typedengword);
		
		
		
	//	System.out.println("get word number" + x);
		
	//	return x;
	}
	
	
	public boolean compareGetRandPlAndGetWordNumber(int getwordnumber) {
		
		int getrandpl = 1;
		   
		System.out.println("compareGetRandPlAndGetWordNumber" + getwordnumber);
		
		
		getrandpl = getRandPl();
		
		if (getrandpl == getwordnumber) {
			return true;
		} else {
			
			return false;
		}
		
	}
	
	
	
	@RequestMapping(value = "/getcompare", method = RequestMethod.GET)
	@ResponseBody
	public String getCompare() {
		
	    int getwordnumber = 1;
		
	    String good = "Good";
	    String bad = "Bad";
	    
	    if (this.compareGetRandPlAndGetWordNumber(getwordnumber)) {
	    	
	    	return good;
	    } else {
		
	    	return bad;
	    }
	}
	
	
}
