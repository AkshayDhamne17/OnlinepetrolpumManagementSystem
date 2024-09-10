package org.petrolpump.admin.repository;

import java.util.ArrayList;
import java.util.List;

import org.petrolpump.admin.config.DBConfig;
import org.petrolpump.admin.model.MachineModel;

public class MachineRepositoryImpl extends DBConfig implements MachineRepository {
	List<Object[]> list;
	int mid;

	public int getMachineIdAutomatic() {
		try {
			stmt = conn.prepareStatement("select max(mid) from machineinfo");
			rs = stmt.executeQuery();
			if (rs.next()) {
				mid = rs.getInt(1);
			}
			return ++mid;
			
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return -1;
		}
	}

	@Override
	public boolean isAddNewMachine(MachineModel model, String typeId[], String capacity[]) {

		
		try {
			mid = this.getMachineIdAutomatic();
			String machineCode = model.getMachineCode();
			stmt = conn.prepareStatement("insert into machineinfo values(" + mid + ",'" + machineCode + "')");
			int value = stmt.executeUpdate();
			if (value > 0) {
				int j = 0;
				for (int i = 0; i < capacity.length; i++) {

					if (capacity[i] != null && !capacity[i].equals("")) {

						stmt = conn.prepareStatement("insert into machinetypejoin values(?,?,?)");
						stmt.setInt(1, mid);
						stmt.setInt(2, Integer.parseInt(typeId[j].trim()));
						stmt.setInt(3, Integer.parseInt(capacity[i].trim()));
						value = stmt.executeUpdate();
						j++;
					}

				}
				return value > 0 ? true : false;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}

	}

	@Override
	public List<Object[]> getallMachines() {
		try {
			list = new ArrayList<Object[]>();
			stmt = conn.prepareStatement(
					" select m.machinecode,f.type,mtj.capacity,m.mid from machineinfo m left join machinetypejoin mtj  on m.mid=mtj.mid left join fueltype f on f.typeid=mtj.typeid;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object obj[] = new Object[] { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4) };
				list.add(obj);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}

	}

	@Override
	public boolean isDeleteMachineById(int mid) {

		try {

			stmt = conn.prepareStatement("delete from machineinfo where mid=?");
			stmt.setInt(1, mid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}

	}

	@Override
	public boolean isUpdateMachine(MachineModel model) {

		try {
			stmt = conn.prepareStatement("update machineinfo set machinecode=? where mid=?");
			stmt.setString(1, model.getMachineCode());
			stmt.setInt(2, model.getId());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}

	}

}
