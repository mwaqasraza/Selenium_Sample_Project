# Sample Project



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.mynisum.com/nisum/gen-ai/sample-project.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.mynisum.com/nisum/gen-ai/sample-project/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thanks to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.


# HowTo setup and execute Grocery Journey

## Pre-requisites needed on Safeway Website (One-time)

1. Goto https://www.safeway.com/
2. Click on "Sign in" on top-right corner
3. Click on Create Account
4. Enter all required details
5. Click on Continue
6. Remember the email address from which you have sign-up as it will be needed in the next section(s) below.

## Project Setup on local machine/VDA

1. Clone project on your local machine from this repository and checkout to branch 'QAAT-226'
2. For VDA - Project should be zipped from local, uploaded to VDA and then unzipped
3. Open IntelliJ
4. Open project on IntelliJ by Open Project option on IntelliJ startup screen
5. Wait for project to load
6. Install Cucumber for Java plugin by clicking on settings icon on top-right corner of the screen
7. Click Settings -> Plugins -> Marketplace
8. Search for Cucumber for Java
9. Click on Install button
10. Click on OK
11. Setup Java SDK on IntelliJ by clicking on settings icon on top-right corner of the screen
12. Click on Project Structure
13. Select Java 17 from SDK dropdown
14. Select Language Level as 17 
15. Click on OK 
16. Open feature file from FeatureFiles/CheckoutOthers.feature
17. Update email address on line no.51 to the actual sign-up email 
18. Run `mvn clean install` to build the project on IntelliJ terminal 

## Execution Steps

1. Goto https://www.safeway.com/
2. Sign in with the same sign-up email
3. Remove all items from cart (if they exists)
4. Goto https://www.safeway.com/customer-account/fulfillment-preferences and delete all addresses (if they exists)
5. Following steps in Scenario "Validation user purchases a Grocery product on E-commerce..." in feature file CheckoutOthers.feature **should be commented out if the scenario is getting re-executed**
``````
When User will wait and Selects fastest delivery time
And User clicks third Continue Button on Checkout Page
```````
6. Click on Play button on Scenario with the name "Validation user purchases a Grocery product on E-commerce..."
7. During execution script will try to sign-in with the provided email address. 
8. Verification code will be sent to that email address
9. Manually on the browser(which was launched by the script), enter the verification code in the text box and click on Sign In button
10. Script will continue running the scenario and will stop when Payment section under Checkout Page is reached
11. For showcasing the diff refer following:
 - Commit Added feature file before generating Code: https://gitlab.mynisum.com/nisum/gen-ai/sample-project/-/merge_requests/3/diffs?commit_id=ba0b46c1c06f95e197b11ec82a2cb06b54c54f63 
 - Commit After generating Code: https://gitlab.mynisum.com/nisum/gen-ai/sample-project/-/merge_requests/3/diffs?commit_id=8d1ad73e776bc3ed963f139880ef8f4bab649efe 
 - Commit After made required changes: https://gitlab.mynisum.com/nisum/gen-ai/sample-project/-/merge_requests/3/diffs?commit_id=043f93fec728ff3041c4f1fcfd1a4e3c9c71e7dc
 **- Mainly changes in locators, commented unwanted and made few corrections in java package declaration**