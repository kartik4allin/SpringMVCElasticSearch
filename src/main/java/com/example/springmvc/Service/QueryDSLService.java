package com.example.springmvc.Service;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.example.springmvc.model.HealthData;
import com.example.springmvc.model.Products;



@Service
public class QueryDSLService {

	@Autowired
	private ElasticsearchTemplate template;

	public List<Products> searchMultiField(String name, int price) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", name))
				.must(QueryBuilders.matchQuery("price", price));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		List<Products> products = template.queryForList(nativeSearchQuery, Products.class);
		return products;
	}

	public List<Products> getProductSearchData(String input) {
		String search = ".*" + input + ".*";
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withFilter(QueryBuilders.regexpQuery("name", search)).build();
		List<Products> products = template.queryForList(searchQuery, Products.class);
		return products;

	}

	public List<Products> multiMatchQuery(String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
				.field("name").field("description").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		List<Products> products = template.queryForList(searchQuery, Products.class);
		return products;
	}
	
	
	public List<HealthData> multiMatchHealthQuery(String text) {
		/*
		 * SearchQuery searchQuery = new
		 * NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
		 * .field("purposeOfVisit").field("mainComplaint").field("pastOcularHistory").
		 * field("pastMedicalHistory").
		 * field("familyHistory").field("allergyHistory").field("currentMedication").
		 * type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
		 */
		SearchQuery searchQuery1 = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text).fuzziness("auto").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
				List<HealthData> products = template.queryForList(searchQuery1, HealthData.class);
		return products;
	}

	public void multiMatchQueryWithAggregation(String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
				.field("name").field("description").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).addAggregation(AggregationBuilders.terms("agg1").field("sold")).build();
		Aggregations aggregations = template.query(searchQuery, new ResultsExtractor<Aggregations>() {

			@Override
			public Aggregations extract(SearchResponse response) {
				// TODO Auto-generated method stub
				
				return response.getAggregations();
			}
			
			
			
		});
				
		System.out.println("response.getAggregations() "+ aggregations);
		System.out.println("response.getAggregations() "+ aggregations.asMap().get("agg1"));
		
		
		
		// given
		/*
		 * NativeSearchQuery searchQuery = new NativeSearchQueryBuilder() //
		 * .withQuery(matchAllQuery()) // .withSearchType(SearchType.DEFAULT) //
		 * .addAggregation(terms("subjects").field("subject")) // .build(); 
		 * 
		 * // when
		 * Aggregations aggregations = operations.query(searchQuery, new
		 * ResultsExtractor<Aggregations>() {
		 * 
		 * @Override public Aggregations extract(SearchResponse response) { return
		 * response.getAggregations(); } }, null,
		 * IndexCoordinates.of(INDEX_NAME).withTypes("article")); // then
		 * assertThat(aggregations).isNotNull();
		 * assertThat(aggregations.asMap().get("subjects")).isNotNull();
		 */
		
		
		/*
		 * SearchResponse sr = client.prepareSearch()
		 * .setQuery(QueryBuilders.matchAllQuery()) .addAggregation(
		 * AggregationBuilders.terms("agg1").field("field") ) .addAggregation(
		 * AggregationBuilders.dateHistogram("agg2") .field("birth")
		 * .calendarInterval(DateHistogramInterval.YEAR) ) .get();
		 * 
		 * // Get your facet results Terms agg1 = sr.getAggregations().get("agg1");
		 */	
		}

}