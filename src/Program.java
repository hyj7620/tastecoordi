import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.tastecoordi.web.dao.ClothesDao;
import com.tastecoordi.web.dao.MemberDao;
import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.dao.QnADao;
import com.tastecoordi.web.dao.mybatis.MyBatisClothesDao;
import com.tastecoordi.web.dao.mybatis.MyBatisMemberDao;
import com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao;
import com.tastecoordi.web.dao.mybatis.MyBatisQnADao;
import com.tastecoordi.web.vo.Clothes;
import com.tastecoordi.web.vo.Member;
import com.tastecoordi.web.vo.Notice;
import com.tastecoordi.web.vo.QnA;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		MemberDao memberDao = new MyBatisMemberDao();
		ClothesDao clothesDao = new MyBatisClothesDao();
		QnADao qnadao = new MyBatisQnADao();
		NoticeDao noticeDao = new MyBatisNoticeDao();

		Scanner scan = new Scanner(System.in);
		int menu;
		while (true) {
			// --------------------------메인 페이지--------------------------

			System.out.println("1.회원 페이지");
			System.out.println("2.의류 페이지");
			System.out.println("3.QnA 페이지");
			System.out.println("4.공지사항 페이지");

			menu = Integer.parseInt(scan.nextLine());

			switch (menu) {

			// --------------------------여기부터 회원페이지--------------------------
			case 1: {
				System.out.println("-------회원페이지-------");
				System.out.println("1.회원 등록");
				System.out.println("2.회원 목록 조회");
				System.out.println("3.회원 검색");
				System.out.println("4.회원 삭제");
				System.out.println("5.회원 정보 수정");
				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1: {

					Member m = new Member();
					System.out.println("아이디: ");
					m.setId(scan.nextLine());
					System.out.println("이름: ");
					m.setName(scan.nextLine());
					System.out.println("패스워드: ");
					m.setPw(scan.nextLine());
					System.out.println("이메일: ");
					m.setEmail(scan.nextLine());
					/*
					 * System.out.println("이미지: "); m.setImage(scan.nextLine());
					 */

					int result = memberDao.addMember(m);

				}
					break;

				case 2: {
					// List<Member> list = memberDao.getMembers("ID", "");
					List<Member> list = memberDao.getMembers(1, "ID", "",
							"2015-04-13", "2015-07-28");
					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i); // get - member객체 하나를 가져온다.
						System.out.printf(
								"uid: %s  name:%s  image:%s   regdate:%s \n",
								m.getId(), m.getName(), m.getRegDate());

						/*
						 * m.getId(), m.getName(), m.getImage(),
						 * m.getRegDate());
						 */
					}
				}
					break;

				case 3: {

					System.out.println("회원 아이디: ");
					String uid = scan.nextLine();

					Member m = memberDao.getMember(uid);

					System.out.printf("id:%s\n", m.getId());
					System.out.printf("name:%s\n", m.getName());
					System.out.printf("pw:%s\n", m.getPw());
					System.out.printf("regdate:%s\n", m.getRegDate());
					/*System.out.printf("image:%s\n", m.getImage());
*/
				}
					break;

				case 4: {
					System.out.println("삭제할 아이디");
					String id = scan.nextLine();
					int result = memberDao.removeMember(id);

				}
					break;

				}

			}
				break;
			// --------------------------여기까지 회원페이지--------------------------

			// --------------------------여기부터 의류페이지--------------------------
			case 2: {

				System.out.println("-------의류페이지-------");
				System.out.println("1.옷 등록");
				System.out.println("2.옷 삭제");
				System.out.println("3.등록된 옷 목록");
				System.out.println("4.상위메뉴로");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1: {
					Clothes c = new Clothes();
					System.out.println("의류코드: ");
					c.setCode(scan.nextLine());
					System.out.println("회원아이디: ");
					c.setMid(scan.nextLine());
					System.out.println("이미지이름: ");
					c.setImageName(scan.nextLine());
					System.out.println("가격: ");
					c.setPrice(scan.nextLine());
					System.out.println("사이트 이름: ");
					c.setSiteName(scan.nextLine());
					System.out.println("링크: ");
					c.setLink(scan.nextLine());
					System.out.println("컬러코드: ");
					c.setColor(scan.nextLine());
					System.out.println("카테고리코드: ");
					c.setCategories(scan.nextLine());

					int result = clothesDao.addClothes(c);

				}
					break;

				case 2: {
					System.out.print("삭제할 의류코드 :");
					String code = scan.nextLine();
					int result = clothesDao.removeClothes(code);

				}
					break;
				case 3: {
					M1: while (true) {

						List<Clothes> list = clothesDao.getClothes(1, "mid",
								"", "2015-05-01", "2015-07-23");

						for (int i = 0; i < list.size(); i++) {
							Clothes c = list.get(i);

							/*
							 * System.out.printf("아이디:%s 이미지 이름 :%s 가격 :%s 색상:%s \n"
							 * , c.getMid(), c.getImageName(),
							 * c.getPrice(),c.getColor());
							 */
						}

						System.out.println("1. 의류 정보 보기");
						System.out.println("2. 의류 검색");
						System.out.println("3. 다음 페이지");
						System.out.println("4. 이전 페이지");
						System.out.println("5. 상위 메뉴로");

						int smenu = Integer.parseInt(scan.nextLine());
						switch (smenu) {
						case 1: {
							System.out.print("검색할 회원 아이디 : ");
							String mid = scan.nextLine();

							Clothes c = clothesDao.getCloth(mid);

							System.out.printf("의류코드:%s\n ", c.getCode());
							System.out.printf("아이디:%s\n ", c.getMid());
							System.out
									.printf("이미지 이름 :%s\n ", c.getImageName());
							System.out.printf("가격:%s\n ", c.getPrice());
							System.out.printf("색상:%s\n ", c.getColor());
							System.out.printf("등록일:%s\n ", c.getRegDate());

							System.out.println("목록으로 가려면 아무키나 누르세요");
							scan.nextLine();
						}
							break;

						case 2: {
							System.out.print("검색할 이름 입력: ");
							String key = scan.nextLine();

							for (int i = 0; i < list.size(); i++) {
								Clothes c = list.get(i);
								System.out.printf("아이디:%s\n이미지이름 %s\n가격 %s\n",
										c.getMid(), c.getImageName(),
										c.getPrice());
								System.out.println("목록으로 가려면 아무키나 누르세요");
								scan.nextLine();
							}
						}

							break;

						case 3:
							break;
						case 4:
							break;
						case 5:

							break M1;

						}
					}

				}
					break;

				case 4:
					break;
				}

			}
				break;
			// --------------------------여기까지 의류페이지--------------------------
			// --------------------------여기부터 QnA페이지--------------------------
			case 3: {

				EXIT1: while (true) {
					// 목록출력
					System.out.println("1. Q&A 조회");
					System.out.println("2. Q&A 등록");
					System.out.println("3. Q&A 삭제");
					System.out.println("4. 상위메뉴로");

					menu = Integer.parseInt(scan.nextLine());

					switch (menu) {

					case 1:// 목록 출력

					{

						// 그릇준비 (검색할것)
						List<QnA> list = qnadao.getQnA(1, "Mid", "", "number",
								"title", "content", "regdate", "hits", "mid",
								"");

						for (int i = 0; i < list.size(); i++) {
							QnA qna = list.get(i); // 객체하나를 가져온다.
							System.out.printf("number:%d\n, mid:%s, title:%s",
									qna.getNumber(), qna.getMid(),
									qna.getTitle());

						}

						System.out.println("1. QnA 내용보기");

					}
						break;

					// 게시글 등록
					case 2: {
						QnA q = new QnA();
						System.out.println("아이디: ");
						q.setMid(scan.nextLine());
						System.out.println("비밀번호: ");
						q.setPwd(scan.nextLine());
						System.out.println("게시글 제목: ");
						q.setTitle(scan.nextLine());
						System.out.println("내용: ");
						q.setContent(scan.nextLine());

						int result = qnadao.addQnA(q);
					}
						break;
					case 3: {
						System.out.println("삭제할 게시글 제목 : ");
						String title = scan.nextLine();
						int result = qnadao.removeQnA(title);
					}

						break;
					case 4:
						break EXIT1;

					}

				}

			}
				break;
			// --------------------------여기까지 QnA페이지--------------------------
			// --------------------------여기여기부터 공지사항
			// 페이지--------------------------
			case 4: {
				System.out.println("-------공지사항페이지-------");
				System.out.println("1.공지 등록");
				System.out.println("2.공지 조회");
				System.out.println("3.공지 수정");
				System.out.println("4.공지 삭제");

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1: {

					Notice n = new Notice();
					/*
					 * System.out.println("번호: "); n.setNumber(scan.nextLine());
					 */
					System.out.println("내용: ");
					n.setContent(scan.nextLine());
					System.out.println("링크: ");
					n.setLink(scan.nextLine());
					System.out.println("이미지: ");
					n.setImage(scan.nextLine());
					System.out.println("관리자 아이디: ");
					n.setMid(scan.nextLine());

					int result = noticeDao.addNotice(n);

				}
					break;

				case 2: {
					List<Notice> list = noticeDao.getNotices(1, "number", "", "2015-04-18", "2015-08-28");
					for (int i = 0; i < list.size(); i++) {
						Notice n = list.get(i); // get - member객체 하나를 가져온다.
						System.out.printf(
								"num: %s  mid:%s  content:%s   date:%s \n",
								n.getNumber(), n.getMid(), n.getContent(),
								n.getDate());
					}

				}
					break;

				case 4: {
					System.out.println("삭제할 번호");
					String number = scan.nextLine();
					int result = noticeDao.removeNotice(number);

				}

				}

			}
			// --------------------------여기까지 공지사항페이지--------------------------

			}
		}
	}
}
