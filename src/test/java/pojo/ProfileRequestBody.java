package pojo;

public class ProfileRequestBody {

	public String company;
	public String website;
	public String location;
	public String status;
	public String skills;
	public String githubusername;
	public String bio;
	public String twitter;
	public String facebook;
	public String linkedin;
	public String youtube;
	public String instagram;

	public ProfileRequestBody(String company, String website, String location, String status, String skills,
			String githubusername, String bio, String twitter, String facebook, String linkedin, String youtube,
			String instagram) {
		this.company = company;
		this.website = website;
		this.location = location;
		this.status = status;
		this.skills = skills;
		this.githubusername = githubusername;
		this.bio = bio;
		this.twitter = twitter;
		this.facebook = facebook;
		this.linkedin = linkedin;
		this.youtube = youtube;
		this.instagram = instagram;
	}

}
