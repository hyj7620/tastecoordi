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
			// --------------------------���� ������--------------------------

			System.out.println("1.ȸ�� ������");
			System.out.println("2.�Ƿ� ������");
			System.out.println("3.QnA ������");
			System.out.println("4.�������� ������");

			menu = Integer.parseInt(scan.nextLine());

			switch (menu) {

			// --------------------------������� ȸ��������--------------------------
			case 1: {
				System.out.println("-------ȸ��������-------");
				System.out.println("1.ȸ�� ���");
				System.out.println("2.ȸ�� ��� ��ȸ");
				System.out.println("3.ȸ�� �˻�");
				System.out.println("4.ȸ�� ����");
				System.out.println("5.ȸ�� ���� ����");
				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1: {

					Member m = new Member();
					System.out.println("���̵�: ");
					m.setId(scan.nextLine());
					System.out.println("�̸�: ");
					m.setName(scan.nextLine());
					System.out.println("�н�����: ");
					m.setPw(scan.nextLine());
					System.out.println("�̸���: ");
					m.setEmail(scan.nextLine());
					/*
					 * System.out.println("�̹���: "); m.setImage(scan.nextLine());
					 */

					int result = memberDao.addMember(m);

				}
					break;

				case 2: {
					// List<Member> list = memberDao.getMembers("ID", "");
					List<Member> list = memberDao.getMembers(1, "ID", "",
							"2015-04-13", "2015-07-28");
					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i); // get - member��ü �ϳ��� �����´�.
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

					System.out.println("ȸ�� ���̵�: ");
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
					System.out.println("������ ���̵�");
					String id = scan.nextLine();
					int result = memberDao.removeMember(id);

				}
					break;

				}

			}
				break;
			// --------------------------������� ȸ��������--------------------------

			// --------------------------������� �Ƿ�������--------------------------
			case 2: {

				System.out.println("-------�Ƿ�������-------");
				System.out.println("1.�� ���");
				System.out.println("2.�� ����");
				System.out.println("3.��ϵ� �� ���");
				System.out.println("4.�����޴���");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
				case 1: {
					Clothes c = new Clothes();
					System.out.println("�Ƿ��ڵ�: ");
					c.setCode(scan.nextLine());
					System.out.println("ȸ�����̵�: ");
					c.setMid(scan.nextLine());
					System.out.println("�̹����̸�: ");
					c.setImageName(scan.nextLine());
					System.out.println("����: ");
					c.setPrice(scan.nextLine());
					System.out.println("����Ʈ �̸�: ");
					c.setSiteName(scan.nextLine());
					System.out.println("��ũ: ");
					c.setLink(scan.nextLine());
					System.out.println("�÷��ڵ�: ");
					c.setColor(scan.nextLine());
					System.out.println("ī�װ��ڵ�: ");
					c.setCategories(scan.nextLine());

					int result = clothesDao.addClothes(c);

				}
					break;

				case 2: {
					System.out.print("������ �Ƿ��ڵ� :");
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
							 * System.out.printf("���̵�:%s �̹��� �̸� :%s ���� :%s ����:%s \n"
							 * , c.getMid(), c.getImageName(),
							 * c.getPrice(),c.getColor());
							 */
						}

						System.out.println("1. �Ƿ� ���� ����");
						System.out.println("2. �Ƿ� �˻�");
						System.out.println("3. ���� ������");
						System.out.println("4. ���� ������");
						System.out.println("5. ���� �޴���");

						int smenu = Integer.parseInt(scan.nextLine());
						switch (smenu) {
						case 1: {
							System.out.print("�˻��� ȸ�� ���̵� : ");
							String mid = scan.nextLine();

							Clothes c = clothesDao.getCloth(mid);

							System.out.printf("�Ƿ��ڵ�:%s\n ", c.getCode());
							System.out.printf("���̵�:%s\n ", c.getMid());
							System.out
									.printf("�̹��� �̸� :%s\n ", c.getImageName());
							System.out.printf("����:%s\n ", c.getPrice());
							System.out.printf("����:%s\n ", c.getColor());
							System.out.printf("�����:%s\n ", c.getRegDate());

							System.out.println("������� ������ �ƹ�Ű�� ��������");
							scan.nextLine();
						}
							break;

						case 2: {
							System.out.print("�˻��� �̸� �Է�: ");
							String key = scan.nextLine();

							for (int i = 0; i < list.size(); i++) {
								Clothes c = list.get(i);
								System.out.printf("���̵�:%s\n�̹����̸� %s\n���� %s\n",
										c.getMid(), c.getImageName(),
										c.getPrice());
								System.out.println("������� ������ �ƹ�Ű�� ��������");
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
			// --------------------------������� �Ƿ�������--------------------------
			// --------------------------������� QnA������--------------------------
			case 3: {

				EXIT1: while (true) {
					// ������
					System.out.println("1. Q&A ��ȸ");
					System.out.println("2. Q&A ���");
					System.out.println("3. Q&A ����");
					System.out.println("4. �����޴���");

					menu = Integer.parseInt(scan.nextLine());

					switch (menu) {

					case 1:// ��� ���

					{

						// �׸��غ� (�˻��Ұ�)
						List<QnA> list = qnadao.getQnA(1, "Mid", "", "number",
								"title", "content", "regdate", "hits", "mid",
								"");

						for (int i = 0; i < list.size(); i++) {
							QnA qna = list.get(i); // ��ü�ϳ��� �����´�.
							System.out.printf("number:%d\n, mid:%s, title:%s",
									qna.getNumber(), qna.getMid(),
									qna.getTitle());

						}

						System.out.println("1. QnA ���뺸��");

					}
						break;

					// �Խñ� ���
					case 2: {
						QnA q = new QnA();
						System.out.println("���̵�: ");
						q.setMid(scan.nextLine());
						System.out.println("��й�ȣ: ");
						q.setPwd(scan.nextLine());
						System.out.println("�Խñ� ����: ");
						q.setTitle(scan.nextLine());
						System.out.println("����: ");
						q.setContent(scan.nextLine());

						int result = qnadao.addQnA(q);
					}
						break;
					case 3: {
						System.out.println("������ �Խñ� ���� : ");
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
			// --------------------------������� QnA������--------------------------
			// --------------------------���⿩����� ��������
			// ������--------------------------
			case 4: {
				System.out.println("-------��������������-------");
				System.out.println("1.���� ���");
				System.out.println("2.���� ��ȸ");
				System.out.println("3.���� ����");
				System.out.println("4.���� ����");

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {
				case 1: {

					Notice n = new Notice();
					/*
					 * System.out.println("��ȣ: "); n.setNumber(scan.nextLine());
					 */
					System.out.println("����: ");
					n.setContent(scan.nextLine());
					System.out.println("��ũ: ");
					n.setLink(scan.nextLine());
					System.out.println("�̹���: ");
					n.setImage(scan.nextLine());
					System.out.println("������ ���̵�: ");
					n.setMid(scan.nextLine());

					int result = noticeDao.addNotice(n);

				}
					break;

				case 2: {
					List<Notice> list = noticeDao.getNotices(1, "number", "", "2015-04-18", "2015-08-28");
					for (int i = 0; i < list.size(); i++) {
						Notice n = list.get(i); // get - member��ü �ϳ��� �����´�.
						System.out.printf(
								"num: %s  mid:%s  content:%s   date:%s \n",
								n.getNumber(), n.getMid(), n.getContent(),
								n.getDate());
					}

				}
					break;

				case 4: {
					System.out.println("������ ��ȣ");
					String number = scan.nextLine();
					int result = noticeDao.removeNotice(number);

				}

				}

			}
			// --------------------------������� ��������������--------------------------

			}
		}
	}
}
