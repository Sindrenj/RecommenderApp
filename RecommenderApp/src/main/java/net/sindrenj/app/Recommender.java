//package net.sindrenj.app;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
//import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
//import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
//import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
//import org.apache.mahout.cf.taste.model.DataModel;
//import org.apache.mahout.cf.taste.recommender.RecommendedItem;
//import org.apache.mahout.cf.taste.similarity.UserSimilarity;
//
//public class Recommender {
//	private User user;
//	private int nRecommendations;
//	private final String filePath;
//	private DataModel model;
//	
//	public Recommender(User user, int nRecommendations, String filePath) throws IOException {
//		this.user = user;
//		this.nRecommendations = nRecommendations;
//		this.filePath = filePath;
//		//Get the data and define the model:
//		model = new FileDataModel(new File(filePath));
//	}
//	
//	
//	public void userBasedRecommendation() throws IOException {
//		//Choose the recommendations algorithm:
//		UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);
//		
//	}
//	
//	public void itemBasedRecommendation() {
////		GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, itemSimilarity);
////				CachingRecommender cachingRecommender = new CachingRecommender(recommender);
////				List<RecommendedItem> recommendations =  cachingRecommender.recommend(user.getId(), nRecommendations);
//	}
//	
//	public void svdBasedRecommendation()  {
//		
//	}
//}
