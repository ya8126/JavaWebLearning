package jp.itagademy.samples.web.mvc.sympleboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContributionList {
	private List<Contribution> contributionList = new ArrayList<>();

	public List<Contribution> getContributionList() {
		return contributionList;
	}

	public void addContribution(String name, String comment, Date date){
		contributionList.add(new Contribution(name, comment, date));
	}

}
