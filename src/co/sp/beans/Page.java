package co.sp.beans;

public class Page {
	
	private int min;
	
	private int max;
	
	private int prevPage;
	
	private int nextPage;
	
	private int pageCnt;

	private int currentPage;
	
	
	
	public Page(int contentCount, int currentPage, int contentPageCount, int pa) {
		
		this.currentPage = currentPage;
		
		
		pageCnt =contentCount / contentPageCount;
		if(contentCount % contentPageCount > 0) {
			pageCnt++;
		}
		
		min = ((currentPage - 1) / contentPageCount) * contentPageCount + 1;
		max = min + pa- 1;
		
		if(max > pageCnt) {
			max = pageCnt;
		}
		
		prevPage = min - 1;
		nextPage = max + 1;
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
}
